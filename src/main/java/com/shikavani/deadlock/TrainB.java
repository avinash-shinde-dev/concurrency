package com.shikavani.deadlock;

public class TrainB implements Runnable{
    private final Intersection intersection;

    public TrainB(Intersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.intersection.takeRoadB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
