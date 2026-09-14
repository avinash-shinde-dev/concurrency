package com.shikavani.locks.reentrantreadwrite;

import java.util.Random;

public class InventoryManager {
    private static final Integer HIGHEST_PRICE = 10;
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        Inventory inventory = new Inventory();

        for (int i = 0; i < 100_000; i++) {
            inventory.addItem(random.nextInt(HIGHEST_PRICE));
        }

        System.out.println("total sum: " + inventory.getPriceCountMap().values().stream().mapToInt(i-> i).sum());
        // I am going to write the data to same inventory
        Thread writer = new Thread(() -> {
            while (true){
                inventory.addItem(random.nextInt(HIGHEST_PRICE));
                inventory.remove(random.nextInt(HIGHEST_PRICE));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        writer.setDaemon(true);
        writer.start();
        // Also, i am going to read the data

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 100_00; i++) {
                int upper = random.nextInt(HIGHEST_PRICE);
                int lower = upper > 0 ? random.nextInt(upper) : 0;
                System.out.println(String.format("Total items within range: [ %s, %s ] - %s", lower, upper, inventory.getNoOfItemsInPriceRange(lower, upper)));
            }
        });

        reader.setDaemon(true);
        reader.start();

        reader.join();

        System.out.println("total sum: " + inventory.getPriceCountMap().values().stream().mapToInt(i-> i).sum());
    }
}
