package com.shikavani.terminate;

public class BlockingThread extends Thread{
    public static void main(String[] args) {
        BlockingThread thread = new BlockingThread();
        thread.start();
        System.out.println("Waiting for task to finish");
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println("Exiting from the blocked code");
        }
    }
}
