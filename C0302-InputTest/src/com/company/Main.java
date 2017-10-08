package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("We will collect some of your personal information\n" +
                "we assure not to make your data public\n" +
                "and won't save the data on any web server.\n" +
                "Do you agree? (y/n)");
        // TODO: 2017/10/8 in.nextChar??
        String agreement = in.nextLine();
        if (!agreement.equalsIgnoreCase("y")) {
            System.exit(0);
        }

        System.out.println("Hello what's your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Welcome, " + name + ". Next year, you'll be " + (age + 1)           );
    }
}
