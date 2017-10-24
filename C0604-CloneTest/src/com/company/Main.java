package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Public", 50000);
            Employee clone = original.clone();
            Employee copy = original;

            System.out.println("original: "+original.toString()+"\n");

            // clone是克隆出来的对象，且使用了深拷贝(Date)，所以原对象未改变
            clone.raiseSalary(5);
            clone.setHireDay(2018,11,22);

            System.out.println("clone:    "+clone.toString());
            System.out.println("original: "+original.toString()+"\n");

            // copy是原对象的引用，所以改变了原来的对象内容
            copy.raiseSalary(5);

            System.out.println("copy:     "+copy.toString());
            System.out.println("original: "+original.toString()+"\n");


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
