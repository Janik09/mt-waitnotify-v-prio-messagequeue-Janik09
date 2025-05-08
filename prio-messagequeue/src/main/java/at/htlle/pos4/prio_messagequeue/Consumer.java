package at.htlle.pos4.prio_messagequeue;


import java.util.Random;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;
    private final Random random = new Random();

    public Consumer(String name, PriorityMessageQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.receiveMessage();
                Thread.sleep(random.nextInt(1500) + 500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
