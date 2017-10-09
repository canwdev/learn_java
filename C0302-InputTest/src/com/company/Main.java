package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("We will collect some of your personal information\n" +
                "we assure not to make your data public\n" +
                "and won't save the data on any web server.\n" +
                "Do you agree? (y/n)");

        String agreement = in.nextLine();
        // String ch = String.valueOf(agreement.charAt(0));
        if (!agreement.equalsIgnoreCase("y")) {
            System.exit(0);
        }

        System.out.println("Hello what's your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
        System.out.printf("Hello, %s. Next year, you'll be %d\n", name, age + 1);
        String formatResult = String.format("Hello, %s. Next year, you'll be %d\n"
                , name, age + 1);
        System.out.println(formatResult);
        {
            in.nextLine();
            System.out.println("Press any key to continue...");
            in.nextLine();
        }

        System.out.println("Welcome to our system, in this system, you can look time.");
        System.out.println(new Date());
        System.out.printf("%tc\n",new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }
}
