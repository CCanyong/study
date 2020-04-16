package com.ccy.interfaceAndAbs.impl;

import com.ccy.interfaceAndAbs.interfaces.Fly;

import java.lang.reflect.Method;

public class Bird implements Fly {

    public void say() {

    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
    }

    @Override
    public void eat() {
        System.out.println("eat...");
    }
}


