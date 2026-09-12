package com.shikavani;

public class SimpleThread {

    public static void main(String[] args) throws InterruptedException {

        // max priority -> 10
        // min priority -> 1
        // default priority of any thread -> 5
        Thread thread = new Thread( () -> {
            System.out.println("New thread: " + Thread.currentThread().getName());
            System.out.println("Priority : " + Thread.currentThread().getPriority());
        });

        thread.setName("Worker Thread");
        //thread.setPriority(Thread.MIN_PRIORITY);
        System.out.println(String.format("We are using thread %s before starting new thread: ", Thread.currentThread().getName()) );
        thread.start();
        System.out.println(String.format("We are using thread %s after starting new thread: ", Thread.currentThread().getName()) );
        Thread.sleep(1000);


    }
}
