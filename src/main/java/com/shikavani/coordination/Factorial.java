package com.shikavani.coordination;

import java.util.ArrayList;
import java.util.List;

public class Factorial {
    // calculating the factorial
    public static void main(String[] args) {
        Long[] inputNumbers = new Long[]{0L , 1L , 234432L, 24L, 67857L, 5555343L};

        List<FactorialThread> threads = new ArrayList<>();
        for (Long inputNumber : inputNumbers){
            FactorialThread thread = new FactorialThread(inputNumber);
            thread.setDaemon(true);
            threads.add(thread);
        }

        // start the calculation
        threads.forEach(thread -> thread.start());

        // This will make sure that main thread should wait until all the threads complete
        // their operation.
        threads.forEach(thread -> {
            try {
                thread.join(2000);
            } catch (InterruptedException e) {throw new RuntimeException(e);
            }
        });
        // t
        threads.forEach(thread -> {
           if(thread.isFinished()){
               System.out.println("Factorial for inputNumber : " + thread.getInputNumber() + " is : " + thread.getResult());
           }else{
               System.out.println("Calculation is still going on for the input number : " + thread.getInputNumber());
           }
        });
    }
}
