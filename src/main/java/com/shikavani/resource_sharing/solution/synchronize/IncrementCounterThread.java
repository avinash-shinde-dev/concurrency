package com.shikavani.resource_sharing.solution.synchronize;

public class IncrementCounterThread extends Thread{
    private InventoryCounter inventoryCounter;

    public IncrementCounterThread(InventoryCounter inventoryCounter) {
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            this.inventoryCounter.increment();
        }
    }

}
