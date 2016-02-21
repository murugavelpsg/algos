package com.muru.multithreading.boundedbuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by msivagna on 2/21/16.
 */
public class WriterThread extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(WriterThread.class);
    private BoundedBuffer boundedBuffer;

    public WriterThread(BoundedBuffer boundedBuffer) {
        super();
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Integer val = new Integer(ThreadLocalRandom.current().nextInt(1, 10));
                LOGGER.debug("Write val = {}", val);
                boundedBuffer.write(val);
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                LOGGER.error("Got exception = ", e);
            }
        }
    }
}
