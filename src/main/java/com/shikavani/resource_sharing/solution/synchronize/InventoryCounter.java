package com.shikavani.resource_sharing.solution.synchronize;

public class InventoryCounter {
    private int item;
    Object lock = new Object();
    public InventoryCounter(int item) {
        this.item = item;
    }

//    public synchronized void increment(){
//        item++;
//    }

    public void increment(){
        synchronized (this.lock){
            item++;
        }
    }

//    public synchronized void decrement(){
//        item--;
//    }

    public synchronized void decrement(){
        synchronized (this.lock){
            item--;
        }
    }


//    public synchronized int getItem() {
//        return item;
//    }

    public synchronized int getItem() {
        synchronized (this.lock){
            return item;
        }
    }

}
