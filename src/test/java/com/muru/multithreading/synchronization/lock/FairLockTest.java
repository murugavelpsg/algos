package com.muru.multithreading.synchronization.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 7/31/16.
 */
public class FairLockTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FairLockTest.class);
    private static final int MAX_THREAD_COUNT = 10;

    /**
     * To check fairness, create callables that returns its own ID and execute it with enough
     * interval in between. The values returned by the callable should be in ascending order.
     */
    private class MyRunnable implements Runnable {
        private Integer id = null;
        private Lock lock = new FairLock();
        private List<Integer> executionOrderList = null;

        public MyRunnable(Integer id, Lock lock, List<Integer> executionOrderList) {
            this.id = id;
            this.lock = lock;
            this.executionOrderList = executionOrderList;
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName(Integer.toString(id));
            try {
                lock.acquire();
                executionOrderList.add(id);
            }
            catch (InterruptedException e) {
                LOGGER.error("Got exception ", e);
                assertTrue(false, "Should not get any exception");
            }
            finally {
                lock.release();
            }
        }
    }

    @Test
    public void testTheFairnessOfTheLock() throws InterruptedException {
        Lock lock = new FairLock();
        List<Integer> actualExecutionOrder = new ArrayList<Integer>();
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
        int CALLABLE_COUNT = 100000;
        for (int i = 0; i < CALLABLE_COUNT; i++) {
            Runnable myRunnable = new MyRunnable(new Integer(i), lock, actualExecutionOrder);
            executor.submit(myRunnable);
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
        List<Integer> expectedExecutionOrder = ((FairLock) lock).getRequestOrder();
        assertEquals(actualExecutionOrder, expectedExecutionOrder);
    }

    /*
        Test for race condition
        The test below tries to use the lock and increment the counter in Callable class
        to CALLABLE_COUNT. The value returned by the future should be from 1 to CALLABLE_COUNT
        after sorting.
     */
    private class SharedVariable {
        private Integer count = 0;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    private class Counter implements Callable<Integer> {
        private Lock simpleLock = null;
        private SharedVariable sharedVariable = null;

        public Counter(Lock simpleLock, SharedVariable sharedVariable) {
            this.simpleLock = simpleLock;
            this.sharedVariable = sharedVariable;
        }

        public Integer call() throws Exception {
            try {
                simpleLock.acquire();
                sharedVariable.setCount(sharedVariable.getCount() + 1);
                return sharedVariable.getCount();
            } finally {
                simpleLock.release();
            }
        }
    }

    @Test
    public void testForRaceCondition() throws InterruptedException {
        Lock simpleLock = new SimpleLock();
        SharedVariable sharedVariable = new SharedVariable();
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        int CALLABLE_COUNT = 1500;
        for (int i = 0; i < CALLABLE_COUNT; i++) {
            Callable<Integer> worker = new Counter(simpleLock, sharedVariable);
            Future<Integer> future = executor.submit(worker);
            futures.add(future);
        }
        List<Integer> returnValues = new ArrayList<Integer>();
        for(Future<Integer> future : futures) {
            try {
                returnValues.add(future.get());
            }
            catch (InterruptedException e) {
                LOGGER.error("Got exception = ", e);
                assertTrue(false);
            }
            catch (ExecutionException e) {
                LOGGER.error("Got exception = ", e);
                assertTrue(false);
            }
        }
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
        List<Integer> expectedReturnValues = new ArrayList<Integer>();
        for (int i = 1; i <= CALLABLE_COUNT; i++) {
            expectedReturnValues.add(i);
        }
        Collections.sort(returnValues);
        assertEquals(returnValues, expectedReturnValues);
    }

    /*
        Test to check if only owner can release the lock
        The following test spawns two threads.
        We should get exception when the thread which doesn't own the
        lock tries to release it
     */
    public class LockAcquiringRunnable implements Runnable {
        private Lock lock;

        public LockAcquiringRunnable(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            try {
                lock.acquire();
            }
            catch (InterruptedException e) {
                assertTrue(false, "Should not get an exception");
            }
        }
    }

    public class LockReleasingRunnable implements Runnable {
        private Lock lock;

        public LockReleasingRunnable(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            try {
                lock.release();
                assertTrue(false, "Should get an exception.");
            }
            catch (IllegalMonitorStateException e) {
                assertTrue(true);
            }
        }
    }

    @Test
    public void mustGetExeptionWhenNonOwnerReleaseLock() throws InterruptedException {
        Lock lock = new SimpleLock();
        Thread lockAcquiringThread = new Thread(new LockAcquiringRunnable(lock));
        Thread lockReleasingThread = new Thread(new LockReleasingRunnable(lock));
        lockAcquiringThread.start();
        Thread.sleep(1000);
        lockReleasingThread.start();
        lockAcquiringThread.join();
        lockReleasingThread.join();
    }
}