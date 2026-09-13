package com.shikavani.coordination;

import java.math.BigInteger;

public class FactorialThread extends Thread{
    private final Long inputNumber;
    private BigInteger result;
    private boolean isFinished;

    public FactorialThread(Long inputNumber) {
        this.inputNumber = inputNumber;
        this.result = BigInteger.ZERO;
        this.isFinished = false;
    }

    public Long getInputNumber() {
        return inputNumber;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public BigInteger factorial(Long inputNumber){
        BigInteger temp = BigInteger.ONE;
        for (int i = 1; i <= this.inputNumber; i++) {
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }

    @Override
    public void run() {
        result = factorial(this.inputNumber);
        isFinished = true;
    }
}
