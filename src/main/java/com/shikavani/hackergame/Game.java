package com.shikavani.hackergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Random random = new Random();
        final Integer MAX_PASSWORD = 1000;
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        System.out.println("Start the game ");
        threads.forEach(Thread::start);

    }

}

record Vault(Integer password){
    public boolean isCorrectPassword(int guess){
        try {
            Thread.sleep(50);
        }catch (InterruptedException ie){

        }
        return this.password.equals(guess);
    }
}
