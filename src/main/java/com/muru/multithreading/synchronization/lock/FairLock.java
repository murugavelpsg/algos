package com.muru.multithreading.synchronization.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by msivagna on 7/31/16.
 * Implements fairness i.e. the thread wait in FIFO order to acquire the locks
 * The following implementation avoids nested monitor lockout and signal miss cases too
 */
public class FairLock implements Lock {
    private static final Logger LOGGER = LoggerFactory.getLogger(FairLock.class);
    private boolean isLocked = false;
    private int lockedCount = 0;
    private Thread ownerThread = null;
    private Queue<QueueObject> queueObjects = new ArrayDeque<QueueObject>();
    //An internal variable added to test the order of the lock request
    List<Integer> requestOrder = new ArrayList<Integer>();

    public void acquire() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        synchronized (this) {
            if (isLocked == true && ownerThread == Thread.currentThread()) {
                lockedCount++;
                return;
            }
            try {
                requestOrder.add(Integer.parseInt(Thread.currentThread().getName()));
            } catch (NumberFormatException e) {
                LOGGER.debug("requestOrder is an internal variable. No need to worry if it is not set");
                LOGGER.debug("Ignoring NumberFormatException");
            }
            queueObjects.add(queueObject);
        }

        //If the lock is available grab it right away
        synchronized (this) {
            if (!isLocked && queueObject == queueObjects.peek()) {
                isLocked = true;
                lockedCount++;
                ownerThread = Thread.currentThread();
                queueObjects.remove();
                return;
            }
        }

        //NOTE: Separating out the wait block from the above condition check eliminates the
        //nested monitor lockout
        //Otherwise wait on the queue object
        //Once notified set the lock to acquired
        //Remove the head of the queue i.e. the object that belongs to the current request
        try {
            queueObject.waitInQueue();
            synchronized (this) {
                isLocked = true;
                lockedCount++;
                ownerThread = Thread.currentThread();
                queueObjects.remove();
            }
        } catch (InterruptedException e) {
            synchronized (this) {
                requestOrder.remove(Integer.parseInt(Thread.currentThread().getName()));
                queueObjects.remove(queueObject);
            }
        }
    }

    public synchronized void release() {
        if (ownerThread != Thread.currentThread()) {
            String msg = String.format("Current thread %s is not the owner of the lock", Thread.currentThread().getName());
            throw new IllegalMonitorStateException(msg);
        }
        lockedCount--;
        if (lockedCount == 0) {
            isLocked = false;
            ownerThread = null;
            if (queueObjects.size() > 0) {
                QueueObject queueObject = queueObjects.peek();
                queueObject.notifyWaitingThreads();
            }
        }
    }

    public List<Integer> getRequestOrder() {
        return requestOrder;
    }

    private class QueueObject {
        //The isSignalled variable avoids any signal misses i.e. a thread cannot wait if
        //it has been already signalled.
        private boolean isSignalled = false;
        public synchronized void waitInQueue() throws InterruptedException {
            while (!isSignalled) {
                wait();
            }
        }

        public synchronized void notifyWaitingThreads() {
            isSignalled = true;
            notifyAll();
        }
    }
}
