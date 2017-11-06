package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(returnSomething());
    }

    static int returnSomething() {
        int n = 10;
        try {
            return throwAnException(n);
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            // System.out.println("Finally this will always be executed\n" +
            //         "and will replace the return statement in try{}");
            // return -2;
        }
        return -1;
    }

    static int throwAnException(int max) throws MyException {
        int i;
        for (i = 0; i < max; i++) {
            // use the vm parameter -ea (or -enableassertions)
            assert i < 3 : "MyAssertion";
            if (i > 5) {
                throw new MyException("MyException: i > 5 ");
            }
        }
        return i;
    }
}
