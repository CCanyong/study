package com.ccy.singleton;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 19/04/2020 18:37
 */
public class StaticSingleton {

    private final static StaticSingleton INSTANCE = new StaticSingleton();

    private StaticSingleton() {

    }

    public static StaticSingleton getINSTANCE() {
        return INSTANCE;
    }
}
