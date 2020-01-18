package classic.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by boileryao on 2020/1/18.
 * Licensed under WTFPL©2020.
 */
public class BlockingQueueSolution {
    private static final int CAPACITY = 4;
    BlockingQueue<Integer> stock = new ArrayBlockingQueue<>(CAPACITY);

    public static void main(String[] args) {
        new BlockingQueueSolution().run();
    }

    private void run() {
        new ConsumerThread().start();
        new ProducerThread().start();
    }

    class ProducerThread extends Thread {
        @Override public void run() {
            for (int i = 0; i < 10; i++) {
                int product = (int) (Math.random() * 100);
                stock.add(product);
                System.out.println("Product product: " + product);
            }
        }
    }

    class ConsumerThread extends Thread {
        @Override public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int product = stock.take();
                    System.out.println("Consume product: " + product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
