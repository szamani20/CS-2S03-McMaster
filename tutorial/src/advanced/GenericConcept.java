/*
It would be nice if we could write a single sort method that could sort
the elements in an Integer array, a String array, or an array of any
type that supports ordering.
Using Java Generic concept, we might write a generic method for sorting
an array of objects, then invoke the generic method with Integer arrays,
Double arrays, String arrays and so on, to sort the array elements.

Primitives (int, double, ...) do not work with Generics. Why? Because
Generic is a compile-time concept. Based on what you pass, the Java compiler
will enforce that type and ensure that the passed type and the expected
type match. So they are replaced as type Object that a primitive cannot
be used for.
 */
package advanced;

import java.util.ArrayList;

public class GenericConcept {
    public GenericConcept() {
        int[] intArray = {1, 2, 3, 4, 5};
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        String[] stringArray = {"Quebec", "Ontario", "Alberta"};

//        // This doesn't work
//        printArray(intArray);

        printArray(integerArray);
        printArray(stringArray);
        System.out.println();

        // Sometimes we need to constraint what kind of objects may be
        // passed as argument (or returned)
        maximum(3, 4, 5);
        maximum(2.3, 3.2, 6.9);
        maximum("Ontario", "Quebec", "Alberta");
        System.out.println();

//        // ArrayList does not extend Comparable, since Generic is checked
//        // at compile time, we receive a compile error here.
//        maximum(new ArrayList<String>(), new ArrayList<Integer>());

        // Let's take a look at Generic class
        UselessBox<String> uselessString = new UselessBox<>();
        UselessBox<Integer> uselessInteger = new UselessBox<>();

        uselessString.setT("Enslaved 2nd Amendment");
        uselessInteger.setT(420);

        System.out.println(uselessString.getT());
        System.out.println(uselessInteger.getT());
    }

    public static <T extends Comparable<T>> void maximum(T a1, T a2, T a3) {
        T max = a1;
        if (a2.compareTo(max) > 0)
            max = a2;
        if (a3.compareTo(max) > 0)
            max = a3;
        System.out.println(max);
    }

    // A Generic method to print array of any type
    public static <T> void printArray(T[] array) {
        for (T element : array)
            System.out.printf("%s ", element);
        System.out.println();
    }

    public static void main(String[] args) {
        new GenericConcept();
    }
}

class UselessBox<T> {
    private T t;

    void setT (T t) {
        this.t = t;
    }

    T getT() {
        return t;
    }
}
