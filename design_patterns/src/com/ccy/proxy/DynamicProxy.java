package com.ccy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(o.getClass());
        System.out.println("代理前...");
        Object invoke = method.invoke(object, objects);
        System.out.println("代理后...");
        return invoke;

    }

}
