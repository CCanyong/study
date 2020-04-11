package com.ccy.classLoading;

public class Teacher extends Person {
    static {
        System.out.println("Teacher is init");
    }

    /*public Teacher() {
        System.out.println("s...");
    }*/

    public Teacher(int i) {
        super(i);
        System.out.println("s..." + i);
    }

    public void say() {
        System.out.println("teacher say");
    }
}
