package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityMessageQueue {
    private final int maxSize;
    private final Queue<Message> priorityQueue = new LinkedList<>();
    private final Queue<Message> normalQueue = new LinkedList<>();

    public PriorityMessageQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void sendMessage(Message msg) throws InterruptedException {
        while (size() >= maxSize) {
            wait();
        }

        if (msg.isPriority()) {
            priorityQueue.offer(msg);
        } else {
            normalQueue.offer(msg);
        }

        System.out.println(Thread.currentThread().getName() + " sendMessage(" + msg.isPriority() + "): " + msg.getContent());
        notifyAll();
    }

    public synchronized Message receiveMessage() throws InterruptedException {
        while (size() == 0) {
            wait();
        }

        Message msg = !priorityQueue.isEmpty() ? priorityQueue.poll() : normalQueue.poll();
        System.out.println(Thread.currentThread().getName() + " receiveMessage(): " + msg.isPriority() + ", " + msg.getContent());
        notifyAll();
        return msg;
    }

    private int size() {
        return priorityQueue.size() + normalQueue.size();
    }
}

