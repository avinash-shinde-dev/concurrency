package com.shikavani.deadlock;

public class TrainA implements Runnable{
    private final Intersection intersection;

    public TrainA(Intersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.intersection.takeRoadA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
