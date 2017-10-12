package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Alice Adams", 75000, LocalDate.of(1987, 12, 15)));
        staff.add(new Employee("Bob Brand", 5000, LocalDate.of(1989, 10, 1)));
        staff.add(new Employee("Carl Cracker", 80000, LocalDate.of(1987, 12, 15)));

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println("[name=" + e.getName()
                    + ",salary=" + e.getSalary()
                    + ",hireDay=" + e.getHireDay()
                    + "]");
        }
    }
}
