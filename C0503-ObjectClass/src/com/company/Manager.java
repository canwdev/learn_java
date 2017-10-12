package com.company;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        // super.equals 已经检查了this和obj都属于同一个类
        Manager other = (Manager) obj;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString()
                + "[bonus=" + bonus
                + "]" + Integer.toHexString(hashCode());
    }
}
