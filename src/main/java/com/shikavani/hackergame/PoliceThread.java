package com.shikavani.hackergame;

public class PoliceThread extends Thread{

    @Override
    public void run() {
        System.out.println("Timer : ");
        for (int i = 10; i > 0 ; i--) {
            try {
                System.out.println(i);
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("I got you hacker, hahaha");
        System.exit(0);
    }
}
