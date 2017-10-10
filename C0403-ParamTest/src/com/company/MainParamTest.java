package com.company;

/**
 * 用来测试方法参数的拷贝（变量）与拷贝引用（对象）
 */
public class MainParamTest {

    public static void main(String[] args) {
        System.out.println("Test tripleValue");
        double percent = 10;
        System.out.println(percent);
        tripleValue(percent);
        System.out.println(percent);

        System.out.println();
        System.out.println("Test tripleSalary");
        Employee harry = new Employee("Harry", 50000);
        System.out.println(harry.getSalary());
        tripleSalary(harry);
        System.out.println(harry.getSalary());

        System.out.println();
        System.out.println("Test swapEmployee");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("a=" + a.getName() + " b=" + b.getName());
        swapEmployees(a, b);
        System.out.println("a=" + a.getName() + " b=" + b.getName());
    }

    /**
     * 将传值（拷贝的值）提高3倍
     * 无效，因为修改的只是复制后的值
     *
     * @param x
     */
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method, x=" + x);
    }

    /**
     * 提升员工3倍工资
     * 有效，因为修改的是对象本身而不是复制的引用
     *
     * @param x
     */
    public static void tripleSalary(Employee x) {
        x.raiseSalary(200); // 提升200%，相当于3倍
        System.out.println("End of method, x.getSalary=" + x.getSalary());
    }

    /**
     * 交换两员工（拷贝的引用）
     * 无效，因为交换的只是拷贝的引用
     *
     * @param x
     * @param y
     */
    public static void swapEmployees(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method, x.getName=" + x.getName());
        System.out.println("End of method, y.getName=" + y.getName());
    }
}
