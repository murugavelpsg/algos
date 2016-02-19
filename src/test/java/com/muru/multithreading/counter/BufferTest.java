package com.muru.multithreading.counter;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 2/16/16.
 */
public class BufferTest {

    @Test
    public void singleProducerAndConsumer() throws InterruptedException {
        Buffer buffer = new Buffer();
        ProducerThread producerThread = new ProducerThread(buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        producerThread.start();
        consumerThread.start();
        Thread.sleep(50000);
    }

    @Test
    public void singleProducerAndMultiConsumer() throws InterruptedException {
        Buffer buffer = new Buffer();
        ProducerThread producerThread = new ProducerThread(buffer);
        List<ConsumerThread> consumerThreadList = new ArrayList<ConsumerThread>();
        Integer consumerThreadCount = 3;
        for (int i = 0; i < consumerThreadCount; i++) {
            consumerThreadList.add(new ConsumerThread(buffer));
        }

        //Start the threads
        producerThread.start();
        for (int i = 0; i < consumerThreadCount; i++) {
            consumerThreadList.get(i).start();
        }
        Thread.sleep(50000);
    }
}