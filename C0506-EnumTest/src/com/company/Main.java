package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = "";
        for (Size s : Size.values()) {
            string += s.toString() + ", ";
        }
        string = string.substring(0,string.length()-2);
        System.out.print("Enter a size: (" + string + "): ");
        String input = in.nextLine();

        Size size = Enum.valueOf(Size.class, input);
        System.out.println(size);
        System.out.println(size.getAbbr());

        System.out.println();
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the " + size);
        }
        Size[] values = Size.values();
        for (int i = 0; i < Size.values().length; i++) {
            System.out.print(values[i].toString() + "\t");
        }

    }
}
