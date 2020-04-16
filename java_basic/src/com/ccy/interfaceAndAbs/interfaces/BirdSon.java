package com.ccy.interfaceAndAbs.interfaces;

import com.ccy.interfaceAndAbs.impl.Bird;

import java.lang.reflect.Method;

public class BirdSon extends Bird {

    public static void main(String[] args) {
        Class<BirdSon> birdSonClass = BirdSon.class;
        Method[] methods = birdSonClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.toString());
        }
    }
}
