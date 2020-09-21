/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package oop;/*
Polymorphism allows us to perform a single action in different ways.
For example each animal may make some sounds. Roar, meow, etc.
So the Animal class should have a sound() method which has no specific
implementation.

In another words, Polymorphism is the capability of a method to do
different things based on the object that it is acting upon.

SO:
Method overloading (static binding) is compile-time polymorphism
Method overriding (dynamic binding) is run-time polymorphism
 */

public class Polymorphism {
}

class Animal {
    // Which sound is going to be called? A runtime decision.
    public void sound() {
        System.out.println("Animal is making a sound");
    }

    public void sound(String uselessArg) {
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow!");
    }
}

class Fox extends Animal {
    @Override
    public void sound() {
        System.out.println("What does the fox say?");
    }
}
