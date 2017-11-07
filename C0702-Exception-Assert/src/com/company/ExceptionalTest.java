package com.company;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ExceptionalTest {
    public static void main(String[] args) {
        int i = 0;
        int nTry = 10000000;
        Stack<String> s = new Stack<>();
        long time1;
        long time2;

        // test a stack for emptiness nTry times
        System.out.println("Testing for empty stack...");
        time1 = new Date().getTime();
        // 如果栈不为空则出栈（当然都是空的）
        for (i = 0; i <= nTry; i++)
            if (!s.empty()) s.pop();
        time2 = new Date().getTime();
        System.out.println((time2 - time1) + " milliseconds");

        // pop an empty stack nTry times and catch the resulting exception
        System.out.println("Catching EmptyStackException...");
        time1 = new Date().getTime();
        for (i = 0; i <= nTry; i++) {
            try {
                s.pop();
            } catch (EmptyStackException e) {
                // 仅仅捕获但不处理这个异常
            }
        }
        time2 = new Date().getTime();
        // 捕获异常所花费的时间大大超过了前者，
        // 因此使用异常的基本规则是：只在异常情况下使用异常机制。
        System.out.println((time2 - time1) + " milliseconds");
    }
}
