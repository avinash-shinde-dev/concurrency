package com.shikavani.resource_sharing.semaphore;

public class CoordinateWorkerRunner implements Runnable{
    private final Barrier barrier;

    public CoordinateWorkerRunner(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try{
            task();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    private void task() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " part 1 of the work is finished");

        barrier.waitForAll(); // wait here

        System.out.println(Thread.currentThread().getName() + " part 2 of the work is finished");

    }
}
