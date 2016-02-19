package com.muru.multithreading.readerwriter;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 2/19/16.
 */
public class ReaderWriterTest {
    private static final int READER_THREAD_COUNT = 3;
    private static final int WRITER_THREAD_COUNT = 3;

    @Test
    public void readerWriterTest() throws InterruptedException {
        ReaderWriter readerWriter = new ReaderWriter();
        List<ReaderThread> readerThreads = new ArrayList<ReaderThread>();
        List<WriterThread> writerThreads = new ArrayList<WriterThread>();

        for (int i = 0; i < READER_THREAD_COUNT; i++) {
            ReaderThread readerThread = new ReaderThread(i, readerWriter);
            readerThreads.add(readerThread);
        }

        for (int i = 0; i < WRITER_THREAD_COUNT; i++) {
            WriterThread writerThread = new WriterThread(i, readerWriter);
            writerThreads.add(writerThread);
        }

        //Start all the treaders
        for (WriterThread writerThread : writerThreads) {
            writerThread.start();
        }

        for (ReaderThread readerThread : readerThreads) {
            readerThread.start();
        }

        Thread.sleep(100000);
    }
}