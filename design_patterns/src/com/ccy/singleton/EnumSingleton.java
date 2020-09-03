package com.ccy.singleton;

/**
 *
 * @author 陈灿勇
 * @version 0.0.1
 * @since 19/04/2020 17:19
 */
public enum EnumSingleton {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.setName("ccy");
        System.out.println(EnumSingleton.INSTANCE.getName());
    }
}
