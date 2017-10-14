package com.company.util;

import java.lang.reflect.*;
import java.util.ArrayList;

import static com.company.util.Util.classLastName;
import static com.company.util.Util.printTabs;

public class ObjectAnalyzer {
    // 循环引用将有可能导致无限递归，ObjectAnalyzer 将记录已经被访问过的对象
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 利用反射分析类的能力输出类信息
     *
     * @param name 类的全名 例 java.util.Date
     */
    public static void printClassInfo(String name) {
        try {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            // getModifiers它将返回一个整型数值，用不同的位开关
            // 用于获取修饰符：描述 public和 static 这样的修饰符使用状况
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print("class " + classLastName(name));
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends " + classLastName(superCl.getName()));
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
            System.out.print(classLastName(name) + "(");

            // 输出参数
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                String paraName = paramTypes[i].getName();
                System.out.print(classLastName(paraName));
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
            System.out.println(classLastName(type.getName()) + " " + name + ";");
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
            System.out.print(classLastName(retType.getName()) + " " + classLastName(name) + "(");

            // 输出参数
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                String paraName = paramTypes[i].getName();
                System.out.print(classLastName(paraName));
            }
            System.out.println(");");
        }
    }

    /**
     * 转换对象到字符串来表达，包含所有的域
     *
     * @param obj 对象
     * @return 字符串
     */
    public String toString(Object obj) {
        if (obj == null)
            return null;

        if (visited.contains(obj))
            return "...";
        visited.add(obj);

        Class cl = obj.getClass();
        if (cl == String.class)
            return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive())
                    r += val;
                else
                    r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);

        return r;
    }

    /**
     * 用于扩展已经填满的数组
     * This method grows an array by allocating a new array of the same type and
     * copying all elements.
     * @param a the array to grow. This can be an object array or a primitive
     * type array
     * @return a larger array that contains all elements of a.
     */
    public static Object copyOf(Object a, int newLength)
    {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
