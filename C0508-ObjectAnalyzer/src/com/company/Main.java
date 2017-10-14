package com.company;

import com.company.util.ObjectAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;

import static com.company.util.ObjectAnalyzer.copyOf;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            squares.add(i * i);
        }

        for (Integer i : squares) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println(new ObjectAnalyzer().toString(squares));

        System.out.println();
        int[] a = { 1, 2, 3 };
        a = (int[]) copyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = { "Tom", "Dick", "Harry" };
        b = (String[]) copyOf(b, 10);
        System.out.println(Arrays.toString(b));
    }
}
