package com.shikavani.resource_sharing.solution.atomic_ops.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class InventoryCounter {
    private AtomicInteger item;
    public InventoryCounter() {
        this.item = new AtomicInteger(0);
    }

//    public synchronized void increment(){
//        item++;
//    }

    public void increment(){
        item.incrementAndGet();
    }

//    public synchronized void decrement(){
//        item--;
//    }

    public void decrement(){
        item.decrementAndGet();
    }


//    public synchronized int getItem() {
//        return item;
//    }

    public int getItem() {
        return item.get();
    }

}
