package com.muru.multithreading.boundedbuffer;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 2/21/16.
 */
public class BoundedBufferTest {
    private static final int READER_THREAD_COUNT = 4;
    private static final int WRITER_THREAD_COUNT = 5;
    private BoundedBuffer boundedBuffer;
    private List<ReaderThread> readerThreads;
    private List<WriterThread> writerThreads;

    @BeforeClass
    public void setup() {
        BasicConfigurator.configure();
        boundedBuffer = new BoundedBuffer(10);
        readerThreads = new ArrayList<ReaderThread>();
        writerThreads = new ArrayList<WriterThread>();
        for (int i = 0; i < READER_THREAD_COUNT; i++) {
            readerThreads.add(new ReaderThread(boundedBuffer));
        }

        for (int i = 0; i < WRITER_THREAD_COUNT; i++) {
            writerThreads.add(new WriterThread(boundedBuffer));
        }
    }

    @Test
    public void testBoundedBuffer() throws InterruptedException {
        for (int i = 0; i < READER_THREAD_COUNT; i++) {
            readerThreads.get(i).start();
        }

        for (int i = 0; i < WRITER_THREAD_COUNT; i++) {
            writerThreads.get(i).start();
        }
        Thread.sleep(100000);
    }
}