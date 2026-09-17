package com.shikavani.virtual_thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 20;
    public static void main(String[] args) throws InterruptedException {

//        Thread platformThread =Thread.ofPlatform().unstarted(() -> System.out.println("Inside thread: " + Thread.currentThread()));
//        platformThread.start();
//        platformThread.join();

//        Thread virtualThread = Thread.ofVirtual().unstarted(() -> System.out.println("Virtual Threads: " + Thread.currentThread()));
//        virtualThread.start();
//        virtualThread.join();

          //Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread());

          BlockingTask runnable = new BlockingTask();
          List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread thread = Thread.ofVirtual().unstarted(runnable);
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.start();
        }
        for (Thread thread : threads){
            thread.join();
        }
    }
}
