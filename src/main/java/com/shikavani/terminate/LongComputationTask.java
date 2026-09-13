package com.shikavani.terminate;

import java.math.BigInteger;

public class LongComputationTask implements Runnable {
    private BigInteger base;
    private BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        System.out.println("starting calculation");
        System.out.println(String.format("%s^%s = %s", base, power, pow(base, power)));
    }

    private BigInteger pow(BigInteger base, BigInteger power){
        BigInteger result = BigInteger.ONE;

        for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Thread is being interrupted.");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }

        return  result;
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new LongComputationTask(BigInteger.valueOf(2000),BigInteger.valueOf(1000000)));
        thread.start();
        thread.interrupt(); // in this scenario the interrupt won't help you.

        // so we need to check the piece of code which causing this
        // and check if the thread is interrupted.
        // Why ?
        // thread.interrupt() -> sets the thread's interrupt flag
        // with isInterrupted() -> it will periodically check if the thread is interrupted, then it stops
        // behaviour could be different for cpu bound tasks than blocked threads ( wait, sleep, join ) etc.
    }
}
