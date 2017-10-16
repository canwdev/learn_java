package com.company;

import com.company.util.ObjectAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            squares.add(i * i);
        }

        for (Integer i : squares) {
            System.out.print(i + " ");
        }

        System.out.println();
        // 转换对象到字符串来表达
        System.out.println(new ObjectAnalyzer().toString(squares));

        System.out.println();
        int[] a = {1, 2, 3};
        // 扩展已经填满的数组
        a = (int[]) ObjectAnalyzer.copyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) ObjectAnalyzer.copyOf(b, 10);
        System.out.println(Arrays.toString(b));
    }
}
