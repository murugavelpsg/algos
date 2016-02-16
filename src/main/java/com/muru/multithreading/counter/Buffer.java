package com.muru.multithreading.counter;

/**
 * A simple buffer class where a producer waits to fill until the buffer becomes empty
 * Consumer consumes the buffer until its empty
 * Created by msivagna on 2/16/16.
 */
public class Buffer {
    private Integer buffer = new Integer(0);

    public void produce() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (buffer > 0) {
                    System.out.println("Waiting for consumers to finish consuming. buffer = " + buffer);
                    this.wait();
                }
                buffer = buffer + 3;
                System.out.println("Replenising the supply. buffer = " + buffer);
                this.notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (buffer <= 0) {
                    System.out.println("Waiting for producer to replenish. buffer = " + buffer);
                    this.wait();
                }
                buffer = buffer - 1;
                System.out.println("Consuming. buffer = " + buffer);
                this.notifyAll();
            }
        }
    }
}
