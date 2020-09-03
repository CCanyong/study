package com.ccy.init;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 27/04/2020 11:18
 */
public class StaticAndFinal {
    public static void main(String[] args) {
        // 使用类常量时不会导致类的初始化
        System.out.println(C.k);
        // 使用类变量时会导致类的初始化
        C.i = 11;
        System.out.println(C.i);
        System.out.println(new C().anInt);
    }
}

class C {
    static {
        System.out.println("init...");
    }

    static int i = 10;  // 类变量，可变
    final int anInt = 12;   // 实例变量，不可变
    static final int k = 1;
}
