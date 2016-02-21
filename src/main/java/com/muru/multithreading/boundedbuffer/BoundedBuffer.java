package com.muru.multithreading.boundedbuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by msivagna on 2/21/16.
 */

/**
 * Problem statement: A bounded buffer supports read and write methods.
 * If a read is attempted on an empty buffer, then the thread will block until an item becomes available;
 * if a write is attempted on a full buffer, then the thread will block until a space becomes available
 */
public class BoundedBuffer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoundedBuffer.class);
    private List<Integer> buffer;
    private Integer currentBufferSize = 0;
    private Integer maxBufferSize;

    private Lock lock = new ReentrantLock();
    private Condition readerQueue = lock.newCondition();
    private Condition writerQueue = lock.newCondition();

    public BoundedBuffer(Integer maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        buffer = new ArrayList<Integer>();
    }

    /**
     * If a read is attempted on an empty buffer, then the thread will block until an item becomes available;
     * @return
     */
    public Integer read() throws InterruptedException {
        Integer val = null;
        ReaderThread readerThread = (ReaderThread) Thread.currentThread();
        try {
            lock.lock();
            while(currentBufferSize == 0) {
                LOGGER.debug("Reader thread {} waiting for the buffer to get full", readerThread.getId());
                readerQueue.await();
            }
            val = buffer.remove(0);
            currentBufferSize--;
            if (currentBufferSize == 0) {
                writerQueue.signalAll();
            }
        } finally {
            lock.unlock();
        }
        return val;
    }

    /**
     * If a write is attempted on a full buffer, then the thread will block until a space becomes available
     * @param val
     * @throws InterruptedException
     */
    public void write(Integer val) throws InterruptedException {
        WriterThread writerThread = (WriterThread) Thread.currentThread();
        try {
            lock.lock();
            while(currentBufferSize == maxBufferSize) {
                LOGGER.debug("Writer thread {} waiting as write attempted on a full buffer",
                                                 writerThread.getId());
                writerQueue.await();
            }
            buffer.add(val);
            currentBufferSize++;
            readerQueue.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
