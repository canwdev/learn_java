package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int n = in.nextInt();
        factorial(n);
    }

    /**
     * 计算n的阶乘，并追踪堆栈轨迹
     *
     * @param n 一个非负整数(0!=1)
     * @return n! = 1*2*3*...*n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();
        for (StackTraceElement e :
                elements) {
            System.out.println(e);
        }

        int r;
        if (n <= 1)
            r = 1;
        else r = n * factorial(n - 1); // 递归

        System.out.println("return " + r);
        return r;
    }
}
