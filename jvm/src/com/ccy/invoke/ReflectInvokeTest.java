package com.ccy.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectInvokeTest {
    class grandFather {
        void say() {
            System.out.println("grandFather is saying");
        }
    }

    class father extends grandFather {
        @Override
        void say() {
            System.out.println("father");
        }
    }

    class son extends father {
        @Override
        void say() {
            try {
                Class<?> aClass = Class.forName("com.ccy.invoke.ReflectInvokeTest.grandFather");
                Method method = aClass.getMethod("say");
                method.invoke(aClass.newInstance());

            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new ReflectInvokeTest().new son().say();
    }
}
