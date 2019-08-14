package oop;/*
Interfaces are used for full abstraction. They look like classes, e.g. they
have method signatures and variables but no implementation.
Unlike classes, multiple interfaces can be extended by a single class.
A class implementing an interface, must also implements all of its methods
Interfaces does not *implement* another interface, they *extend* them.
 */

public class InterfaceConcept implements Inf2 {

    @Override
    public void method1() {
        System.out.println(useless);
        System.out.println(useless2);
    }

    @Override
    public void method2() {
        System.out.println(useless);
        System.out.println(useless2);
    }
}

interface Inf1 {
    // Variables are public, static and final by default.
    // Therefore they must be initialized when defined.
    String useless = "Useless";

    // Methods are by default abstract and public
    void method1();
}

interface Inf2 extends Inf1 {
    String useless2 = "Useless2";
    void method2();
}

