package at.htlle.pos4.prio_messagequeue;

import java.util.Random;
public class Producer extends Thread {
        private final PriorityMessageQueue queue;
        private final Random random = new Random();

        public Producer(String name, PriorityMessageQueue queue) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    boolean priority = random.nextBoolean();
                    String content = "Message from " + getName();
                    Message msg = new Message(priority, content);
                    queue.sendMessage(msg);
                    Thread.sleep(random.nextInt(1000) + 500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


