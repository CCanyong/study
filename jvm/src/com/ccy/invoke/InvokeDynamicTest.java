package com.ccy.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

public class InvokeDynamicTest {

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
            // 只能调用到父类的方法
            // super.say();
            // 使用MethodType调用父类
            // 传入参数
            // 第一个：返回类型
            // 后续为方法参数
            MethodType mt = MethodType.methodType(void.class);
            try {
                MethodHandle handle = lookup().findSpecial(grandFather.class, "say", mt, getClass());
                handle.invoke(this);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        (new InvokeDynamicTest().new son()).say();
    }
}


