package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printTitle("Let's output some kana! 输出一些仮名");

        int Hiragana = 12353;
        System.out.println("Hiragana:");
        for (int i = 0; i < 83; i++) {
            System.out.print((char) Hiragana + "\t");
            Hiragana++;
        }
        System.out.println();
        System.out.println("Katakana:");
        int Katakana = 12449;
        for (int i = 0; i < 83; i++) {
            System.out.print((char) Katakana + "\t");
            Katakana++;
        }
        System.out.println();
        printTitle("Goal money calculator! 目标算金钱计算器");

        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need?");
        double goal = in.nextDouble();

        System.out.println("How much money will you make every month?");
        double monthly = in.nextDouble();

        double balance = 0;
        int months = 0;

        if (monthly > 0) {
            while (balance < goal) {
                balance += monthly;
                months++;
            }

            if (months <= 12) {
                System.out.printf("You can achieve goal after %d months\n", months);
            } else {
                double years = (double) months / (double) 12;
                System.out.printf("You can achieve goal after %d months, about %.1f years\n", months, years);
            }
        } else {
            System.out.println("Never.");
        }


        printTitle("抽奖，从n个数字中抽取k个数字且完全匹配的中奖率");
        System.out.println("(k) How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("(n) What is the highest number you can draw?");
        int n = in.nextInt();

        // 大数值可以处理包含任意长度数字序列的数值
        // 有 lotteryOdds 种可能的结果
        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1))
                    .divide(BigInteger.valueOf(i));
        }
        System.out.println("你的中奖率是 1/" + lotteryOdds + ", Good luck!");
    }

    private static void printTitle(final String title) {
        System.out.println("\n" + title);
        for (int i = 0; i < title.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
