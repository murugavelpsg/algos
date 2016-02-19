package com.muru.multithreading.threads;

/**
 * Created by msivagna on 2/19/16.
 */
public class MyThread extends Thread {
    private final Integer threadId;

    public MyThread(Integer threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("threadId = " + threadId);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Got exception = ");
                e.printStackTrace();
            }
        }
    }
}
