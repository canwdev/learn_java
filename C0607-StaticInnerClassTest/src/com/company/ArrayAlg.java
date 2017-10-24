package com.company;


public class ArrayAlg {
    /**
     * 同时计算数组中的最大值与最小值
     * @param values
     * @return Pair对象，包含最大值与最小值
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double v: values){
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }

    // 静态内部类
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }
}
