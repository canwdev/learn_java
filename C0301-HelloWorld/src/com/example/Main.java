package com.example;

public class Main {

    public static void main(String[] args) {
        String all = String.join(" · ", "H", "E", "L", "L", "O");
        // Java 8 API [Document](https://docs.oracle.com/javase/8/docs/api/index.html)
        System.out.println("Hello world\u2122\n" + all);
    }
}
