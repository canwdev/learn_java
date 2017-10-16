package com.company;

import java.util.Comparator;

/**
 * 此类用于排序ArrayList
 * 用法 staffList.sort(new SortBySalary());
 */
public class SortBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
