package com.shikavani.deadlock;

public class Intersection {
    Object roadA = new Object();
    Object roadB = new Object();

    public void takeRoadA() throws InterruptedException {
        synchronized (this.roadA){
            System.out.println("Road A is blocked by thread: " + Thread.currentThread().getName());
            // we need to make sure that no other train is passing on other road.

            synchronized (this.roadB){
                System.out.println("Train A is passing on road A");
                // simulate the train passing by thread sleep
                Thread.sleep(10);
            }
        }
    }

    public void takeRoadB() throws InterruptedException {
        synchronized (this.roadB){
            System.out.println("Road B is blocked by thread: " + Thread.currentThread().getName());
            // we need to make sure that no other train is passing on other road.

            synchronized (this.roadA){
                System.out.println("Train B is passing on road B");
                // simulate the train passing by thread sleep
                Thread.sleep(10);
            }
        }
    }
}
