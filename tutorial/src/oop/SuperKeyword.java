package oop;/*
Basically super keyword refers to the immediate parent class.
There are some usages for super keyword including:
1. Accessing data members of the parent class
2. To call the constructor of the parent class
3. To access the methods of the parent class (specifically when they are
overridden in the child class)
 */

public class SuperKeyword {
}

class ParentClass {
    ParentClass() {
        System.out.println("No arg parent constructor");
    }

    ParentClass(String arg) {
        System.out.println("Parametrized constructor");
    }

    protected void printMessage() {
        System.out.println("Parent says hello!");
    }
}

class SubClass extends ParentClass {
    SubClass() {
//        // If we don't explicitly call any of the parent constructors
//        // using the super keyword, the Java compiler would do that implicitly
//        super("Hello!");

        System.out.println("Child constructor");
    }

    public static void main(String[] args) {
        SubClass sc = new SubClass();

        // We may also use super keyword to distinguish between
        // overridden and parent method
        sc.display();
    }

    private void display() {
        printMessage();
        super.printMessage();
    }

    @Override
    protected void printMessage() {
        System.out.println("Child says hello!");
    }
}
