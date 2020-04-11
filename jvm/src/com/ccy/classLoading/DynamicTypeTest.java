package com.ccy.classLoading;

public class DynamicTypeTest {
    public static void main(String[] args) {
        // Person person = new Person();
        Person teacher = new Teacher(1);
        teacher.say();
    }
}
