package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 10:22
 */
public class Test1 {
    public static void main(String[] args) {
        final LinkedList<Integer> cache = new LinkedList<>();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}

class Consumer implements Runnable {
    private Object lock;
    private LinkedList<Integer> cache;


    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    while (cache.isEmpty()) {  // 缓冲池非空时等待
                        lock.wait();
                    }
                    System.out.println("消费" + cache.get(0));
                    cache.removeFirst();
                    lock.notifyAll();   // 通知消费者
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {
    private Object lock;
    private LinkedList<Integer> cache;

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                synchronized (lock) {
                    while (!cache.isEmpty()) {  // 缓冲池非空时等待
                        lock.wait();
                    }
                    System.out.println("生产" + i);
                    cache.add(i++);
                    lock.notifyAll();   // 通知消费者
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
