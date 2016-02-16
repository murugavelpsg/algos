package com.muru.multithreading.counter;

/**
 * Created by msivagna on 2/16/16.
 */
public class ProducerThread extends Thread {
    private Buffer buffer;

    public ProducerThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.produce();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
