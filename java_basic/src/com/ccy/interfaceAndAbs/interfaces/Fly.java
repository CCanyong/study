package com.ccy.interfaceAndAbs.interfaces;

public interface Fly {

    default void fly() {
        System.out.println("i can fly");
        eat();
    }

    static void go() {
        System.out.println("i can go");
    }

    void eat();
}
