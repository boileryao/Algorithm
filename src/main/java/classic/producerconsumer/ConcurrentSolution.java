package classic.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by boileryao on 2020/1/18.
 * Licensed under WTFPL©2020.
 */
public class ConcurrentSolution {
    public static void main(String[] args) {
        FoodBucket foodBucket = new FoodBucket();
        new Thread(new Consumer(foodBucket), "消费者一").start();
        new Thread(new Consumer(foodBucket), "消费者二").start();
        new Thread(new Consumer(foodBucket), "消费者三").start();

        new Thread(new Producer(foodBucket), "生产者一").start();
        new Thread(new Producer(foodBucket), "生产者一").start();
        new Thread(new Producer(foodBucket), "生产者一").start();
    }

    static class Producer implements Runnable {
        private FoodBucket foodBucket;

        public Producer(FoodBucket foodBucket) {
            this.foodBucket = foodBucket;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                foodBucket.produce();
            }
        }
    }

    static class Consumer implements Runnable {
        private FoodBucket foodBucket;

        public Consumer(FoodBucket foodBucket) {
            this.foodBucket = foodBucket;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                foodBucket.consume();
            }
        }
    }

    static class FoodBucket {
        private static final int MAX_NUM = 5;
        private int foodCount = 0;
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void produce() {
            lock.lock();
            try {
                while (foodCount == MAX_NUM) {
                    System.out.println(Thread.currentThread().getName() + ", full, size = " + foodCount);
                    condition.await();
                }
                foodCount++;
                System.out.println(Thread.currentThread().getName() + ", produce foodId = " + foodCount);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consume() {
            lock.lock();
            try {
                while (foodCount == 0) {
                    System.out.println(Thread.currentThread().getName() + ", nothing");
                    condition.await();
                }
                foodCount--;
                System.out.println(Thread.currentThread().getName() + ", consumed foodId = " + foodCount);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
