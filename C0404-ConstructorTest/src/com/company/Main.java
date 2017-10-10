package com.company;

import static java.lang.System.out;

public class Main {

    static {
        out.println("Hello, this is from Main's static initialization block!");
    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            String output = String.format("%d. Name: %s,\tSalary: %.2f"
                    ,e.getId(), e.getName(), e.getSalary());
            out.println(output);
        }
    }
}
