package com.muru.multithreading.synchronization.lock;

/**
 * Created by msivagna on 7/30/16.
 * Notes:
 *  - Doesn't implement any fairness
 *  - Simple Lock is not reentrant
 */
public class SimpleLock implements Lock {
    private volatile boolean isLocked = false;
    private volatile Integer lockedCount = 0;
    private volatile Thread ownerThread = null;

    public synchronized void acquire() throws InterruptedException {
        //Wait if the lock is not available
        while (isLocked && Thread.currentThread() != ownerThread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        ownerThread = Thread.currentThread();
    }

    public synchronized void release() {
        //Only the owner can release the lock
        if (!Thread.currentThread().equals(ownerThread)) {
            String msg = String.format("Current thread %s is not the owner of the lock", Thread.currentThread().getName());
            throw new IllegalMonitorStateException(msg);
        }
        lockedCount--;
        if (lockedCount == 0) {
            isLocked = false;
            ownerThread = null;
            notifyAll();
        }
    }
}
