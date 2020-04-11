package com.ccy.proxy;

public class StaticAgencyTest {
    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new Student());
        staticProxy.say();
    }
}
