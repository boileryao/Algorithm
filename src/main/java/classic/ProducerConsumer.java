package classic;

/**
 * Created by boileryao on 2018/10/19.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class ProducerConsumer {

    private static final Object LOCK = new Object();
    private static final int MAX = 3;
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Producer()).start();
            new Thread(new Consumer()).start();
        }
    }

    private static final class Producer implements Runnable {

        @Override public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (LOCK) {
                    try {
                        while (count >= MAX) LOCK.wait();
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Producer: " + Thread.currentThread().getName() + "，Current" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    private static final class Consumer implements Runnable {

        @Override public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (LOCK) {
                    try {
                        while (count <= 0) LOCK.wait();
                        count--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Consumer: " + Thread.currentThread().getName() + "，Current" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
