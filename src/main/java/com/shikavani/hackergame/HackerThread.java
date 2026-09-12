package com.shikavani.hackergame;

public abstract class HackerThread extends Thread{
    private final Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
    }

    public Vault getVault() {
        return vault;
    }

    @Override
    public void start(){
        System.out.println("Starting the hacker thread: " + this.getName());
        super.start();
    }
}

class AscendingHackerThread extends HackerThread {

    public AscendingHackerThread(Vault vault) {
        super(vault);
        this.setName("AscendingHacker");
    }


    @Override
    public  void run(){

        for (int guess = 1; guess < 1000; guess++) {
            if(super.getVault().isCorrectPassword(guess)){
                System.out.println("Password guess : " + guess);
                System.out.println("Ascending Hacker stole the money, hahahaa");
                System.exit(0);
            }
        }
    }
}

class DescendingHackerThread extends HackerThread {

    public DescendingHackerThread(Vault vault) {
        super(vault);
        this.setName("DescendingHacker");
    }

    @Override
    public  void run(){

        for (int guess = 1000; guess >= 1; guess--) {
            if(super.getVault().isCorrectPassword(guess)){
                System.out.println("Password guess : " + guess);
                System.out.println("Descending Hacker stole the money, hahahaa");
                System.exit(0);
            }
        }
    }
}

