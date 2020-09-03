package com.ccy.throwable;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 24/04/2020 10:17
 */
public class ExceptionTest {

    // 方法中抛出异常必须在方法声明上标出
    public void say() throws Exception {
        throw new Exception();
    }

    // 调用方法抛出异常，必须对异常进行处理：捕获或抛出
    public void useSay() throws Exception {
        say();
    }

    public void useSay3() {
        try {
            say();
        } catch (Exception e) {
            System.out.println("...");
        }
    }

    public void testMyException() throws MyException {
        throw new MyException();
    }

    public static void main(String[] args) {

    }

}
