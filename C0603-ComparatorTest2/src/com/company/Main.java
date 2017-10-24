package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String[] friends = {"Peter", "Bill", "Van"};
        // 实例化比较器
        Comparator comp = new LengthComparator();

        // 直接比较
        if (comp.compare(friends[0], friends[1])>0) {
            System.out.println(">");
        }

        for (int i = 0; i < 2; i++) {
            for (String s : friends) {
                System.out.print(s + "   ");
            }
            System.out.println();

            if (i == 0) {
                System.out.println("-- Sort by String.length() --");
                // 排序
                Arrays.sort(friends, new LengthComparator());
            }
        }
    }
}
