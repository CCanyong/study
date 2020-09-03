package com.ccy.singleton;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 19/04/2020 18:31
 */
public class DoubleCheckSingleton {

    private String name;

    /**
     * 使用volatile修饰，禁止指令重排
     */
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton.getInstance().setName("ccy");
        System.out.println(DoubleCheckSingleton.getInstance().getName());
    }
}
