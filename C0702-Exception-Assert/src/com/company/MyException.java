package com.company;

/**
 * 自定义的异常类
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
