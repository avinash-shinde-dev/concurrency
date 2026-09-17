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

        // Thread interruption:

        // Latency/ Performance?
        // How we decide the no of subtasks?
        // general purpose computations -> no of cpu cores

        // Inherent cost of parallelization and aggregation?

        // 1. Breaking task into multiple tasks
        // 2. thread creation and pass tasks to thread
        // 3. time between thread.start() and thread getting scheduled
        // 4. time until the last thread finishes and signals
        // 5. Time until the aggregator thread run
        // 6. aggregation of sub results into the single artifact

        // CAn we break any task into subtasks?
        // ans -> No,

    }
}