package com.company;

import java.time.LocalDate;

public class Main extends Object {

    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 75000, LocalDate.of(1987, 12, 15));
        System.out.println(alice1.toString());
        System.out.println(alice1.hashCode());
        Employee alice2 = alice1;
        System.out.println(alice2.toString());
        System.out.println(alice2.hashCode());
        Employee alice3 = new Employee("Alice Adams", 75000, LocalDate.of(1987, 12, 15));
        System.out.println(alice3.toString());
        System.out.println(alice3.hashCode());
        Employee bob = new Employee("Bob Brand", 5000, LocalDate.of(1989, 10, 1));
        System.out.println(bob.toString());
        System.out.println(bob.hashCode());

        System.out.println();
        System.out.println("alice1 == alice2 " + (alice1 == alice2));
        System.out.println("alice1 == alice3 " + (alice1 == alice3));

        System.out.println();
        System.out.println("alice1.equals(alice2) " + alice1.equals(alice2));
        System.out.println("alice1.equals(alice3) " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob) " + alice1.equals(bob));

        System.out.println();
        Manager carl = new Manager("Carl Cracker", 80000, LocalDate.of(1987, 12, 15));
        System.out.println(carl);
        System.out.println(carl.hashCode());
        Manager boss = new Manager("Carl Cracker", 80000, LocalDate.of(1987, 12, 15));
        System.out.println(boss);
        System.out.println(boss.hashCode());
        boss.setBonus(5000);
        System.out.println(boss);
        System.out.println(boss.hashCode());

        System.out.println();
        System.out.println("carl.equals(boss) "+carl.equals(boss));


    }
}
