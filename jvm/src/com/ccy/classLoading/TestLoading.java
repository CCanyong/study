package com.ccy.classLoading;

public class TestLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        // ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // Class<?> aClass = systemClassLoader.loadClass("com.ccy.classLoading.Person");
        Class<?> aClass = Class.forName("com.ccy.classLoading.Person");
        System.out.println(aClass.getClassLoader());
        System.out.println("...");


    }
}
