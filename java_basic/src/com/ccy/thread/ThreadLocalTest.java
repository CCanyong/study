package com.ccy.thread;

public class ThreadLocalTest {


    public static void main(String[] args) {
        new ThreadT().start();
    }
}

class ThreadT extends Thread {

    @Override
    public void run() {
        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("abc");
        String s = threadLocal.get();
        System.out.println(s);
    }
}
