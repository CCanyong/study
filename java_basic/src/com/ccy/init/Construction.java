package com.ccy.init;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 27/04/2020 11:13
 */
public class Construction {
    public static void main(String[] args) {
        new B();
        System.out.println("...");
        new B(1);
    }
}

class A {
    public A() {
        System.out.println("A()");
    }

    public A(int i) {
        System.out.println("A(int i)");
    }
}

class B extends A {
    public B() {
        System.out.println("B()");
    }

    public B(int i) {
        super(i);   // 未显式调用时，此处均为super();即无参构造;若父类不存在无参构造，则编译错误
        System.out.println("B(int i)");
    }
}