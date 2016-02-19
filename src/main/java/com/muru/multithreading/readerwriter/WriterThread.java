package com.muru.multithreading.readerwriter;

/**
 * Created by msivagna on 2/19/16.
 */
public class WriterThread extends Thread {
    final Integer threadId;
    ReaderWriter readerWriter;

    public WriterThread(Integer threadId, ReaderWriter readerWriter) {
        this.threadId = threadId;
        this.readerWriter = readerWriter;
    }

    @Override
    public void run() {
        try {
            readerWriter.write(this);
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
