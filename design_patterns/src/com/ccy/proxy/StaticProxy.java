package com.ccy.proxy;

public class StaticProxy implements Person {
    // 使用组合方式，传入被代理对象
    private Person person;

    public StaticProxy(Person person) {
        this.person = person;
    }

    @Override
    public void say() {
        // 行为增强
        System.out.println(person.getClass() + " : 要说话");
        person.say();
        System.out.println(person.getClass() + " : 说完了");
    }
}
