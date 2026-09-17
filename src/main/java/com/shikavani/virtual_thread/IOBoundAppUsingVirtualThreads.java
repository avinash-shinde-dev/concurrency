package com.shikavani.virtual_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundAppUsingVirtualThreads {
    private static final int NO_OF_TASK = 10_000;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        performTask();
        System.out.println("Time took: " + (System.currentTimeMillis() - start));
    }

//    private static void performTask(){
//        try(ExecutorService executorService = Executors.newFixedThreadPool(1000)){
//            for (int i = 0; i < NO_OF_TASK; i++) {
//                executorService.submit(() -> blockingOperation());
//            }
//        }
//    }

    // platform threads - 16170 ms
    // virtual threads - 8481 ms // took the half of time
    private static void performTask(){
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < NO_OF_TASK; i++) {
                executorService.submit(() -> {
                    for (int j = 0; j < 100; j++) {
                        blockingOperation();
                    }
                });
            }
        }
    }

    private static void blockingOperation(){
        try{
            System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
            Thread.sleep(10) ;// block the thread for 1 sec.

        }catch (InterruptedException e){

        }
    }
}
