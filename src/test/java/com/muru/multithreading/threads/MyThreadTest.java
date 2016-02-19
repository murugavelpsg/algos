package com.muru.multithreading.threads;

import org.testng.annotations.Test;

/**
 * Created by msivagna on 2/19/16.
 */
public class MyThreadTest {

    private static final int MY_THREAD_COUNT = 10;

    @Test
    public void checkIfThreadsRunInParallel() throws InterruptedException {
        for (int i = 0; i < MY_THREAD_COUNT; i++) {
            MyThread myThread = new MyThread(i);
            myThread.start();
        }
        Thread.sleep(1000000);
    }
}