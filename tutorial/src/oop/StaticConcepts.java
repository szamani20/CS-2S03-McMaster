package oop;

public class StaticConcepts {
    static int num;
    int num2;
    static {
        num = 23;
//        // non-accessible
//        num2 = 24;
        System.out.println("Hello 1");
    }
    static {
        System.out.println("Hello 3");
    }

    private void nonStaticMethod() {
        num = 25;
        System.out.println(num);

        // can call a static method
        staticMethod();
    }

    private static void staticMethod() {
        System.out.println("Hello!");

//        // No access to non-static variables
//        num2 = 24;

//        // cannot call a non static method
//        nonStaticMethod();
    }

    public static void main(String[] args) {
        System.out.println("Hello 2");
    }
}
