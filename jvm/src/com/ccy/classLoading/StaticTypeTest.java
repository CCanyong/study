package com.ccy.classLoading;

/**
 * 静态分类
 * 方法重载时参数的类型为定义时的静态类型，而编译时的动态类型
 */
public class StaticTypeTest {
    public static void main(String[] args) {
        StaticTypeTest staticTypeTest = new StaticTypeTest();
        Person teacher = new Teacher(1);

        staticTypeTest.test(teacher);
    }

    public void test(Person person) {
        System.out.println("person");
    }

    public void test(Teacher teacher) {
        System.out.println("teacher");
    }
}
