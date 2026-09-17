package com.shikavani.resource_sharing.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barrier {
    private final  int noOfWorkers;
    private final Semaphore semaphore = new Semaphore(0);
    private int counter=0;
    private final Lock lock = new ReentrantLock();

    public Barrier(int noOfWorkers) {
        this.noOfWorkers = noOfWorkers;
    }

    public void waitForAll() throws InterruptedException {
        lock.lock();

        boolean isLastWorker = false;
        try {
            counter++;

            if(counter == noOfWorkers){
                isLastWorker = true;
            }
        }finally {
            lock.unlock();
        }

        if(isLastWorker){
            semaphore.release(noOfWorkers-1); // why ?
        }else{
            semaphore.acquire();
        }
    }
}
