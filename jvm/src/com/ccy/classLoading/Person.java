package com.ccy.classLoading;

import org.w3c.dom.ls.LSOutput;

public class Person {
    static {
        System.out.println("init Person");
    }

    /*public Person(){
        System.out.println("p...");
    }*/

    public Person(int i){
        System.out.println("p..."+i);
    }

    public void say(){
        System.out.println("person say");
    }

}
