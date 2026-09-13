package com.shikavani.deadlock;

public class Station {
    public static void main(String[] args) {

        Intersection intersection = new Intersection();
        Thread t1 = new Thread(new TrainA(intersection));
        t1.setName("Train A");
        Thread t2 = new Thread(new TrainB(intersection));
        t2.setName("Train B");

        t1.start();
        t2.start();
    }
}
