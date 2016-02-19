package com.muru.multithreading.readerwriter;

/**
 * Created by msivagna on 2/19/16.
 */
public class ReaderThread extends Thread {
    final Integer threadId;
    ReaderWriter readerWriter;

    public ReaderThread(Integer threadId, ReaderWriter readerWriter) {
        this.threadId = threadId;
        this.readerWriter = readerWriter;
    }

    @Override
    public void run() {
        try {
            readerWriter.read();
        }
        catch (InterruptedException e) {
            System.out.println("Got exception = ");
            e.printStackTrace();
        }
    }

    public Integer getThreadId() {
        return threadId;
    }
}
