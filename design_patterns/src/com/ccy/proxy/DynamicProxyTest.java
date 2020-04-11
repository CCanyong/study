package com.ccy.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {

        Student student = new Student();
        DynamicProxy dynamicProxy = new DynamicProxy(student);
        Person person = (Person) Proxy.newProxyInstance(student.getClass().getClassLoader(),
                student.getClass().getInterfaces(), dynamicProxy);
        person.say();

    }
}
