package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("抽奖预测：从n个数字中抽取k个数字的预测");
        System.out.println("(k) How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("(n) What is the highest number you can draw?");
        int n = in.nextInt();

        // 产生1~n的数组
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // 随机产生中奖结果
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // 创建一个随机下标在0~(n-1)之间
            int r = (int) (Math.random() * n);
            // 设置随机选择的数值
            result[i] = numbers[r];
            // 将被选中的数值设为最后的数值，并将n缩短一位，防止抽重
            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("使用以下序列, You will be rich!");
        /*for (int r : result) {
            System.out.print(r + "\t");
        }*/
        System.out.println(Arrays.toString(result));
        System.out.println("------------------------");

        final int NMAX = 10;

        // 初始化一个不规则三角形数组
        int[][] odds = new int[NMAX + 1][];
        for (int i = 0; i <= NMAX; i++) {
            odds[i] = new int[i + 1];
        }

        // 填充数组
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                // 使用二项式系数来填充（binomial coefficient）
                int lotteryOdds = 1;
                for (int l = 1; l <= j; l++) {
                    lotteryOdds = lotteryOdds * (i - l + 1) / l;
                }
                odds[i][j] = lotteryOdds;
            }
        }

        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
