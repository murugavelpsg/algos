package com.muru.multithreading.boundedbuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by msivagna on 2/21/16.
 */
public class ReaderThread extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderThread.class);
    private BoundedBuffer boundedBuffer;

    public ReaderThread(BoundedBuffer boundedBuffer) {
        super();
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Integer val = boundedBuffer.read();
                LOGGER.debug("Read val = {}", val);
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                LOGGER.error("Got exception = ", e);
            }
        }
    }
}
