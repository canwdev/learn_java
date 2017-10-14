package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final boolean SHOW_FULL_NAME = false;

    public static void main(String[] args) {
        //classClassTest();
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        printClassInfo(name);
    }

    /**
     * 利用反射分析类的能力
     * @param name 类的全名 例 java.util.Date
     */
    private static void printClassInfo(String name) {
        try {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            // getModifiers它将返回一个整型数值，用不同的位开关
            // 用于获取修饰符：描述 public和 static 这样的修饰符使用状况
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print("class " + getLastName(name));
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends " + getLastName(superCl.getName()));
            System.out.println(" {");
            printConstructors(cl);
            System.out.println();
            printFields(cl);
            System.out.println();
            printMethods(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 输出构造器
     *
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            printTabs(1);
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(getLastName(name) + "(");

            // 输出参数
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                String paraName = paramTypes[i].getName();
                System.out.print(getLastName(paraName));
            }
            System.out.println(");");
        }
    }

    /**
     * 输出域
     *
     * @param cl
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            printTabs(1);
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(getLastName(type.getName()) + " " + name + ";");
        }
    }

    /**
     * 输出方法
     *
     * @param cl
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            printTabs(1);
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(getLastName(retType.getName()) +" "+ getLastName(name) + "(");

            // 输出参数
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                String paraName = paramTypes[i].getName();
                System.out.print(getLastName(paraName));
            }
            System.out.println(");");
        }
    }

    /**
     * just a Class 类测试
     */
    public static void classClassTest() {
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

    /**
     * 输出i个tab，每个tab4个空格
     *
     * @param i
     */
    public static void printTabs(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("    ");
        }
    }

    /**
     * 获取“.”最后的名称
     *
     * @param paraName 例 java.lang.Double
     * @return 例 Double
     */
    public static String getLastName(String paraName) {

        if (!SHOW_FULL_NAME && paraName.contains(".")) {
            return paraName.substring(paraName.lastIndexOf(".") + 1);
        } else {
            return paraName;
        }
    }
}
