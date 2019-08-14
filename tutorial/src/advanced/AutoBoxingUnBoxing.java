/*
Autoboxing: Automatic conversion of primitive types to the object of
their corresponding wrapper classes is known as autoboxing.
For example: conversion of int to Integer, long to Long,
double to Double etc.
Unboxing: vice versa.

Primitive type	Wrapper class
boolean	        Boolean
byte	        Byte
char	        Character
float	        Float
int	            Integer
long	        Long
short	        Short
double	        Double

Wrapper class is an OOP concept, here they are used to convert
primitives into objects. Broadly, when you wrap an object over
another object (or primitive) that first object is a wrapper.
Even more broadly for the concept of wrapping, a Java program
may wrap around a Python program. This happens a lot when
developing big software systems.
 */
package advanced;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUnBoxing {
    public AutoBoxingUnBoxing() {
        // 23 here is int (primitive) but the method expects
        // Integer (Wrapper class, an object). Autoboxing happens here.
        autoboxingExample(23);

        // Unboxing happens here
        unboxingExample(new Integer(24));

        // What actually happens? Java compiler automatically
        // change the code for us at compile time
        Integer num = 23; // --> Integer num = Integer.valueOf(23);
        int num2 = num; // --> int num2 = num.intValue();
    }

    void autoboxingExample(Integer arg) {
        System.out.println("Useless arg: " + arg);

        // Another example: adding primitives to ArrayList
        List<Integer> list = new ArrayList<>();
        // Autoboxing happens here
        list.add(23);
    }

    void unboxingExample(int arg) {
        System.out.println("Useless arg again: " + arg);

        // Again another example with ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(23);

        // Unboxing happens here. get() returns Integer which is
        // unboxed to primitive int num
        int num = list.get(0);
    }

    public static void main(String[] args) {
        new AutoBoxingUnBoxing();
    }
}
