package at.htlle.pos4.prio_messagequeue;

public class App {
    public static void main(String[] args) {
        PriorityMessageQueue queue = new PriorityMessageQueue(5); // max 5 Nachrichten

        // Producer starten
        for (int i = 1; i <= 2; i++) {
            Producer producer = new Producer("Producer" + i, queue);
            producer.start();
        }

        // Consumer starten
        for (int i = 1; i <= 2; i++) {
            Consumer consumer = new Consumer("Consumer" + i, queue);
            consumer.start();
        }
    }
}
