package com.shikavani.resource_sharing.solution.atomic_ops.atomic_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        String oldName = "old name";
//        String newName = "new name";
//
//        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
//        atomicReference.set("unexpected name");
//        if(atomicReference.compareAndSet(oldName, newName)){
//            System.out.println("new value is : " + atomicReference.get());
//        }else{
//            System.out.println("Nothing change.");
//        }
//
        // 871 555 152
        // 838 360 011 ( 3 times faster )

        // 285 161 429 (
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
             stack.push(random.nextInt());
        }

        List<Thread> threads = new ArrayList<>();

        int pushThreads = 2;
        int popThreads = 2;

        for (int i = 0; i < pushThreads; i++) {
            Thread thread = new Thread(() -> {
                while(true){
                    stack.push(random.nextInt());
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }

        for (int i = 0; i < popThreads; i++) {
            Thread thread = new Thread(() -> {
                while(true){
                    stack.pop();
                }
            });
            thread.setDaemon(true);
            threads.add(thread);
        }

        threads.forEach(t -> t.start());

        Thread.sleep(10000); // 10 secs

        System.out.println("Total no of operations in 10 secs : " + stack.getCounter());
    }
}
