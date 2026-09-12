package com.shikavani;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // Context switching -> switching between threading
        // Context Switching cost:
        // it's not cheap, but its the price that we pay for concurrency.
        // Each thread consumes resources in the CPU and memory
        // When we switch to the different thread
        // -> we need to store the resource for one thread
        // -> restore the resources of another thread.

        // What is Thrashing?
        // If there are too many threads, then system will spend more time on
        // managing the threads than the actual productive work. ( Overhead )


        // Thread Scheduling ?
        // 1. FIFO -> first come first serve.
        // 2. SJF -> shortest job first

        // problems -> Starvetion

        // How it actually work ?
        // Dynamic Priority -> Static Priority ( set by developer )  + Bonus
        // Os maintains this dynamic priority

    }
}