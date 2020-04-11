package com.ccy.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;
import static java.lang.invoke.MethodHandles.throwException;

public class InvokeDynamicTest2 {
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
                Field impl_lookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                impl_lookup.setAccessible(true);
                MethodHandle say = ((MethodHandles.Lookup) impl_lookup.get(null)).findSpecial(grandFather.class,
                        "say", mt, grandFather.class);
                say.invoke(this);
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
        (new InvokeDynamicTest2().new son()).say();
    }
}
