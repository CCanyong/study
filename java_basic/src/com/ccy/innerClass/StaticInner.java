package com.ccy.innerClass;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 20/04/2020 15:15
 */
public class StaticInner {

    static String string = "ccy";

    public void say() {
        // 1. 外部类可直接调用静态内部类的静态方法、静态属性
        Inner.print();
        System.out.println(Inner.name);
    }

    static class Inner {
        static {
            System.out.println("inner class init");
        }

        private static String name = "ccy";

        public void say() {
            // 2. 静态内部类中，可以直接使用外部类的静态方法或属性
            System.out.println("inner class say" + string);
        }

        public static void print() {
            System.out.println("inner print");
        }
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        System.out.println("...");
        //Inner inner = (Inner) StaticInner.new Inner();
        Inner inner = new Inner();
        inner.say();

    }


}
