package com.company;

import java.time.LocalDate;

// 泛型测试 2
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906, 12, 9), // G. Hopper
                        LocalDate.of(1815, 12, 10), // A. Lovelace
                        LocalDate.of(1903, 12, 3), // J. von Neumann
                        LocalDate.of(1910, 6, 22), // K. Zuse
                };

        Pair<LocalDate> result = ArrayAlg.minMax(birthdays);
        System.out.println("min: " + result.getFirst() + "\n" + "max: " + result.getSecond());
    }

    public static class ArrayAlg {

        /**
         * 获取任意实现了Comparable接口的数组的最大值与最小值的Pair对象
         * @param a an array of objects of type T
         * @param <T> 类型变量放在修饰符（这里是 public static) 的后面，返回类型的前面。
         * @return
         */
        public static <T extends Comparable> Pair<T> minMax(T[] a) {
            if (a == null || a.length == 0) return null;
            T min = a[0];
            T max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (min.compareTo(a[i]) > 0) min = a[i];
                if (max.compareTo(a[i]) < 0) max = a[i];
            }
            return new Pair<>(min, max);
        }
    }
}
