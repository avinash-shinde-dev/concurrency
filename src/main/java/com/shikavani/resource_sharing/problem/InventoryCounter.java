package com.shikavani.resource_sharing.problem;

public class InventoryCounter {
    private int item;

    public InventoryCounter(int item) {
        this.item = item;
    }

    public void increment(){
        item++;
    }

    public void decrement(){
        item--;
    }

    public int getItem() {
        return item;
    }
}
