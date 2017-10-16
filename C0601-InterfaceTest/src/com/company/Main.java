package com.company;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> staffList = new ArrayList<>();

        staffList.add(new Employee("Alice Adams", 75000, LocalDate.of(1987, 12, 15)));
        staffList.add(new Employee("Bob Brand", 5000, LocalDate.of(1989, 10, 1)));
        staffList.add(new Employee("Carl Cracker", 80000, LocalDate.of(1987, 12, 15)));

        for (int i = 0; i < 2; i++) {
            for (Employee e : staffList) {
                System.out.println("[name=" + e.getName()
                        + ",salary=" + e.getSalary()
                        + ",hireDay=" + e.getHireDay()
                        + "]");
            }
            if (i==0) {
                staffList.sort(new SortBySalary());
                System.out.println("排序ArrayList");
            }
        }

        // 排序数组
        System.out.println("-------------------------------------------");
        Employee[] staffArray = new Employee[3];

        staffArray[0] = new Employee("Alice Adams", 75000, LocalDate.of(1987, 12, 15));
        staffArray[1] = new Employee("Bob Brand", 5000, LocalDate.of(1989, 10, 1));
        staffArray[2] = new Employee("Carl Cracker", 80000, LocalDate.of(1987, 12, 15));

        for (int i = 0; i < 2; i++) {
            for (Employee e : staffArray) {
                System.out.println("[name=" + e.getName()
                        + ",salary=" + e.getSalary()
                        + ",hireDay=" + e.getHireDay()
                        + "]");
            }
            if (i==0) {
                Arrays.sort(staffArray);
                System.out.println("排序Array");
            }
        }


    }
}
