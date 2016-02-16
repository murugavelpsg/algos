package com.muru.multithreading.counter;

/**
 * Created by msivagna on 2/16/16.
 */
public class ConsumerThread extends Thread {
    private Buffer buffer;

    public ConsumerThread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.consume();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
