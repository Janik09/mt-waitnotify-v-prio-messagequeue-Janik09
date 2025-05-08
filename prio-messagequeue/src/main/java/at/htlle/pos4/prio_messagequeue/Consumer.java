package at.htlle.pos4.prio_messagequeue;


import java.util.Random;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;
    private final Random random = new Random();


    public Consumer(PriorityMessageQueue queue) {
        this.queue = queue;
    }
}

