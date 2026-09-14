package com.shikavani.locks.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PriceContainer {
    private double bitcoinPrice;
    private double etherPrice;
    private double ripplePrice;
    private final Lock lock = new ReentrantLock();

    public PriceContainer(){};

    public PriceContainer(double bitcoinPrice, double etherPrice, double ripplePrice) {
        this.bitcoinPrice = bitcoinPrice;
        this.etherPrice = etherPrice;
        this.ripplePrice = ripplePrice;
    }

    public double getBitcoinPrice() {
        return bitcoinPrice;
    }

    public void setBitcoinPrice(double bitcoinPrice) {
        this.bitcoinPrice = bitcoinPrice;
    }

    public double getEtherPrice() {
        return etherPrice;
    }

    public void setEtherPrice(double etherPrice) {
        this.etherPrice = etherPrice;
    }

    public double getRipplePrice() {
        return ripplePrice;
    }

    public void setRipplePrice(double ripplePrice) {
        this.ripplePrice = ripplePrice;
    }

    public Lock getLock() {
        return lock;
    }
}
