package com.muru.multithreading.synchronization.lock;

/**
 * Created by msivagna on 7/30/16.
 */
public interface Lock {
    /**
     * Once the lock is acquired this method prevents other threads from entering
     * the critical section. Other threads wait until the lock is released
     * @throws InterruptedException
     */
    void acquire() throws InterruptedException;

    /**
     * Only the owner of the lock can release it. Before releasing the lock
     * all the waiting threads are notified.
     */
    void release();
}
