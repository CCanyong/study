package com.ccy.interfaceAndAbs;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 23:21
 */
public class SameFuncTest {
}

interface A {
    default void func() {
        System.out.println("A");
    }
}

interface B {
    default void func() {
        System.out.println("B");
    }
}

/**
 * 一个类己成多个接口时，若接口种默认方法有冲突，必须覆写，否则编译错误
 */
class Sub implements A, B {

    @Override
    public void func() {

    }
}

class Father {
    public void func() {
        System.out.println("father");
    }
}

/**
 * 当继承父类与接口种的默认方法有冲突时，父类方法优先级最高
 */
class Sub2 extends Father implements A, B {

}
