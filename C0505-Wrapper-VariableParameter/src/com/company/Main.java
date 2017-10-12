package com.company;

import org.omg.CORBA.IntHolder;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //包装器
        Integer a = 32;
        Integer b = 32;
        // Java 实现却有可能(may)让 a==b 成立
        System.out.println(a == b);
        a++;
        System.out.println(a);
        int a1 = a;
        int a2 = Integer.parseInt("-00032");
        System.out.println(a2);

        // 如果在一个条件表达式中混合使用 Integer 和 Double 类型，Integer 值就会拆箱
        // 提升为 double，再装箱为 Double
        // 装箱和拆箱是编译器认可的，而不是虚拟机
        Double x = 32.0;
        System.out.println(true ? b : x); // Prints 32.0

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        //这种变换被称为自动装箱 （ autoboxing )
        list.add(Integer.valueOf(4));

        IntHolder changeable = new IntHolder(1);
        System.out.println(changeable.value);
        addOne(changeable);
        System.out.println(changeable.value);

        System.out.println(maxNumber(5.85, 5.64, 3.67, 4.94, 5.83));
    }

    public static void addOne(IntHolder n) {
        n.value += 1;
    }

    public static double maxNumber(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double n :
                values) {
            if (n > largest) {
                largest = n;
            }
        }
        return largest;
    }
}
