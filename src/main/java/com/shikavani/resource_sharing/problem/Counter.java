package com.shikavani.resource_sharing.problem;

public class Counter {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter(0);

        IncrementCounterThread thread1 = new IncrementCounterThread(inventoryCounter);
        DecrementCounterThread thread2 = new DecrementCounterThread(inventoryCounter);

        thread1.start();
        // thread1.join();
        thread2.start();
        // thread2.join();

        // Now both the threads will access the shared resources, will cause the race condition
        // and it will result into inconsistent results each time.
        thread1.join();
        thread2.join();

        System.out.println("Final value: " + inventoryCounter.getItem());

    }
}
