package com.shikavani.resource_sharing.problem;

public class DecrementCounterThread extends Thread{
    private InventoryCounter inventoryCounter;

    public DecrementCounterThread(InventoryCounter inventoryCounter) {
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            this.inventoryCounter.decrement();
        }
    }

}
