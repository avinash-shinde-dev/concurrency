package com.shikavani.resource_sharing.semaphore;

import java.util.ArrayList;
import java.util.List;

public class SemaphoreExample {

    public static void main(String[] args) {
        int noOfThreads = 3;

        List<Thread> threads = new ArrayList<>();

        Barrier barrier = new Barrier(noOfThreads);

        for (int i = 0; i < noOfThreads; i++) {
            threads.add(new Thread(new CoordinateWorkerRunner(barrier)));
        }

        for (Thread thread : threads){
            thread.start();
        }
    }
}
