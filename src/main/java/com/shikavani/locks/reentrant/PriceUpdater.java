package com.shikavani.locks.reentrant;

import java.util.Random;

public class PriceUpdater implements Runnable{
    private final PriceContainer priceContainer;// shared resource
    private final Random random;

    public PriceUpdater(PriceContainer priceContainer, Random random) {
        this.priceContainer = priceContainer;
        this.random = random;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // trying to acquire the lock, if it is used by other thread, it will wait
                priceContainer.getLock().lock();
                Thread.sleep(10000); // add some delay
                priceContainer.setBitcoinPrice(this.random.nextDouble(2000));
                priceContainer.setEtherPrice(this.random.nextDouble(200));
                priceContainer.setRipplePrice(this.random.nextDouble(500));


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                priceContainer.getLock().unlock(); // release the lock.
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
