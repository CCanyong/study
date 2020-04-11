package thread_basic;

import java.util.concurrent.*;

public class CreateThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread1().start();
        new Thread(new Thread2()).start();
        FutureTask<String> stringFutureTask = new FutureTask<>(new Thread3());
        new Thread(stringFutureTask).start();
        String s = stringFutureTask.get();
        System.out.println(s);
        Future<String> submit = Executors.newFixedThreadPool(1).submit(new Thread3());
        String s1 = submit.get();
        System.out.println(s1);
        System.out.println("...");
        new Thread(()->{
            System.out.println("函数式编程");
        }).start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "继承Thread");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "实现Runnable");
    }
}

class Thread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "aaa";
    }

}
