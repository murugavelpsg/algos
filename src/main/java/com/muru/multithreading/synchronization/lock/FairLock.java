package com.muru.multithreading.synchronization.lock;

import java.util.*;

/**
 * Created by msivagna on 7/31/16.
 * Implements fairness i.e. the thread wait in FIFO order to acquire the locks
 */
public class FairLock implements Lock {
    private boolean isLocked = false;
    private Thread ownerThread = null;
    private Queue<QueueObject> queueObjects = new ArrayDeque<QueueObject>();
    //An internal variable added to test the order of the lock request
    List<Integer> requestOrder = new ArrayList<Integer>();

    public void acquire() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        synchronized (this) {
            requestOrder.add(Integer.parseInt(Thread.currentThread().getName()));
            queueObjects.add(queueObject);
        }

        //If the lock is available grab it right away
        synchronized (this) {
            if (!isLocked && queueObject == queueObjects.peek()) {
                isLocked = true;
                ownerThread = Thread.currentThread();
                queueObjects.remove();
                return;
            }
        }

        //Otherwise wait on the queue object
        //Once notified set the lock to acquired
        //Remove the head of the queue i.e. the object that belongs to the current request
        try {
            queueObject.waitInQueue();
            synchronized (this) {
                isLocked = true;
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
        isLocked = false;
        ownerThread = null;
        if (queueObjects.size() > 0) {
            QueueObject queueObject = queueObjects.peek();
            queueObject.notifyWaitingThreads();
        }
    }

    public List<Integer> getRequestOrder() {
        return requestOrder;
    }

    private class QueueObject {
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
