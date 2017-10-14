package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         classClassTest();
    }

    public static void classClassTest(){
        Scanner in = new Scanner(System.in);
        System.out.println(in.getClass());
        System.out.println(in.getClass().getName());

        System.out.println();
        try {
            Random generator = new Random();
            // getClass 返回一个Class 类型的实例
            Class clannad = generator.getClass();
            // getName获取完整的类名 className = "java.util.Random"
            String className = clannad.getName();
            System.out.println(generator.nextInt(9999) + " " + className);
            // 调用静态方法 forName 获得类名对应的 Class对象实例
            Class cl = Class.forName(className);
            // 获取Class对象的第三种方法
            Class cl1 = int.class;
            // newInstance可以用来动态地创建一个Object类的实例
            Object object = cl.newInstance();
            Random r1 = (Random) object;
            System.out.println(r1.nextInt(666));

            System.out.println();
            String str = "java.util.Random";
            System.out.println(str + "@" + Integer.toHexString(str.hashCode()));
            Object ran = Class.forName(str).newInstance();
            System.out.println(((Random) ran).nextInt(100) + " " + ran);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        /* getName 方法在应用于数组类型的时候会返回一个很奇怪的名字
        System.out.println(String[].class.getName());
        System.out.println(Double[].class.getName());
        System.out.println(int[].class.getName());
        System.out.println(char[].class.getName());*/
    }
}
