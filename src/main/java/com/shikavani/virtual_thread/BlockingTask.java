package com.shikavani.virtual_thread;

public class BlockingTask implements Runnable{

    // Help to understand mounting and unmounting of threads
    @Override
    public void run() {
        System.out.println("Before sleep : " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After sleep : " + Thread.currentThread());

    }
}
