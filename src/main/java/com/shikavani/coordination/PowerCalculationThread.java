package com.shikavani.coordination;

import java.math.BigInteger;

public class PowerCalculationThread extends Thread{
    private BigInteger base;
    private BigInteger power;
    private BigInteger result;
    public PowerCalculationThread(BigInteger base, BigInteger power){
        this.base = base;
        this.power = power;
    }

    @Override
    public void run(){
        this.result = power(this.base, this.power);
    }

    private BigInteger power(BigInteger base, BigInteger power){
        BigInteger temp = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)){
            temp = temp.multiply(base);
        }
        return temp;
    }

    public BigInteger getResult() {
        return result;
    }
}
