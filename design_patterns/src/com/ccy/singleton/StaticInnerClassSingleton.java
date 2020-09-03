package com.ccy.singleton;

/**
 * 静态内部类实现的单例模式
 * 懒汉式，线程安全
 * 与类加载机制相关，外部类加载的时候，不会加载内部类,只有当
 * 使用到内部类时，才会对内部类进行加载，从而实现懒加载
 *
 * @author 陈灿勇
 * @version 0.0.1
 * @since 19/04/2020 18:38
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    static class Instance {
        static {
            System.out.println("init inner class");
        }

        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return Instance.INSTANCE;
    }

    public static void say() {
        System.out.println("...");
    }

    public static void main(String[] args) {
        StaticInnerClassSingleton.say();
        System.out.println("//");
        StaticInnerClassSingleton.getInstance();
    }
}
