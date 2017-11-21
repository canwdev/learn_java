package com.company;

// 泛型测试 3
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minMaxBonus(managers, result);
        System.out.println("First: " + result.getFirst().getName() + " $" + result.getFirst().getSalary() + "\n"
                + "Second: " + result.getSecond().getName() + " $" + result.getSecond().getSalary());

        System.out.println("--- Now swap it ---");
        maxMinBonus(managers, result);
        System.out.println("First: " + result.getFirst().getName() + " $" + result.getFirst().getSalary() + "\n"
                + "Second: " + result.getSecond().getName() + " $" + result.getSecond().getSalary());
    }

    /**
     * 带有超类型限定的通配符可以向泛型对象写入，带有子类型限定的通配符可以从泛型对象读取。
     * @param managers
     * @param result
     */
    private static void minMaxBonus(Manager[] managers, Pair<? super Manager> result) {
        if (managers.length == 0) return;
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i = 1; i < managers.length; i++) {
            if (min.getBonus() > managers[i].getBonus()) min = managers[i];
            if (max.getBonus() < managers[i].getBonus()) max = managers[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    private static void maxMinBonus(Manager[] managers, Pair<? super Manager> result) {
        minMaxBonus(managers, result);
        ArrayAlg.swapHelper(result);    // OK - swapHelper捕获通配符类型
    }

    private static void printBuddies(Pair<? extends Employee> buddies) {
        Employee first = buddies.getFirst();
        Employee second = buddies.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static class ArrayAlg {
        public static boolean hasNulls(Pair<?> p) {
            return p.getFirst() == null || p.getSecond() == null;
        }

        // swapHelper 是一个泛型方法，而 swap 不是，它具有固定的 Pair<?> 类型的参数
        public static void swap(Pair<?> p) {
            swapHelper(p);
        }

        public static <T> void swapHelper(Pair<T> pair) {
            // 为在交换的时候必须临时保存第一个元素，此时只能使用<T>
            T t = pair.getFirst();
            pair.setFirst(pair.getSecond());
            pair.setSecond(t);
        }
    }
}
