package com.shikavani.coordination;

import java.math.BigInteger;

public class Power {
    public static void main(String[] args) throws InterruptedException {

        PowerCalculationThread thread1 = new PowerCalculationThread(BigInteger.valueOf(10),BigInteger.valueOf(5));
        PowerCalculationThread thread2 = new PowerCalculationThread(BigInteger.valueOf(20),BigInteger.valueOf(15));

        thread1.start();
        thread2.start();

        // Thread.sleep(10000); // wait for 10 sec
        // wait until thread1 and thread2 finish it's job
        thread1.join();
        thread2.join();
        BigInteger result = thread1.getResult().add(thread2.getResult());
        System.out.println(result);
    }
}
