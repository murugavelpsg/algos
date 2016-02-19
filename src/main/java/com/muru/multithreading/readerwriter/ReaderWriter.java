package com.muru.multithreading.readerwriter;

/**
 * Created by msivagna on 2/18/16.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem statement:
 * - Readers can access database when no writers
 * – Writers can access database when no readers or writers
 */
public class ReaderWriter {
    private Integer activeReader = 0;
    private Integer activeWriter = 0;
    private Integer waitingReader = 0;
    private Integer waitingWriter = 0;

    final Lock lock = new ReentrantLock();
    final Condition writerWaitQueue = lock.newCondition();
    final Condition readerWaitQueue = lock.newCondition();

    public void read() throws InterruptedException {
        ReaderThread readerThread = (ReaderThread) Thread.currentThread();
        while(true) {
            try {
                lock.lock();
                while (activeWriter + waitingWriter > 0) {
                    waitingReader++;
                    System.out.println(String.format("Reader %d waiting as there are active and waiting writers",
                                                     readerThread.getThreadId()));
                    readerWaitQueue.await();
                    waitingReader--;
                }
                activeReader++;
                System.out.println(String.format("Reader %d read from DB", readerThread.getThreadId()));
                Thread.sleep(500);
                activeReader--;
                if (activeReader == 0 && waitingWriter > 0) {
                    writerWaitQueue.signalAll();
                }
            } finally {
                System.out.println("ReaderWriter.read - Releasing the lock");
                lock.unlock();
                //Waiting for a second after releasing the lock as threads are running in a tight loop
                Thread.sleep(1000);
            }
        }
    }

    public void write() throws InterruptedException {
        WriterThread writerThread = (WriterThread) Thread.currentThread();
        while(true) {
            try {
                lock.lock();
                while (activeReader + activeWriter > 0) {
                    waitingWriter++;
                    System.out.println(String.format("Writer %d waiting as there are active readers and writers",
                                                     writerThread.getThreadId()));
                    writerWaitQueue.await();
                    waitingWriter--;
                }
                activeWriter++;
                System.out.println(String.format("Writer %d writes to DB", writerThread.getThreadId()));
                Thread.sleep(500);
                activeWriter--;
                if (waitingWriter > 0) {
                    writerWaitQueue.signalAll();
                } else if (waitingReader > 0) {
                    readerWaitQueue.signalAll();
                }
            } finally {
                System.out.println("ReaderWriter.write - Releasing the lock");
                lock.unlock();
                //Waiting for a second after releasing the lock as threads are running in a tight loop
                Thread.sleep(1000);
            }
        }
    }

    public Integer getActiveReader() {
        return activeReader;
    }

    public Integer getActiveWriter() {
        return activeWriter;
    }

    public Integer getWaitingReader() {
        return waitingReader;
    }

    public Integer getWaitingWriter() {
        return waitingWriter;
    }
}
