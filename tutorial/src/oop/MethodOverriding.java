/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package oop;/*
Declaring a method in sub class which is already present in parent class
is known as method overriding
This way a child class can give its own specific behaviour to the parent
class version of behaviour
 */

public class MethodOverriding {
}

//// We already defined a class with this name INSIDE the package
//// So we can't do this again.
//class ParentClass {
//
//}

class ParentClass2 {
    // private, static, and final methods cannot be overridden
    public void printMessage() {
        System.out.println("Parent class");
    }

    // If any abstract method is declared (and therefore the class itself
    // must be abstract), it should be overridden in the child class.
}

class ChildClass extends ParentClass2 {

//    // Access Modifier cannot be more restrictive than that of the parent class
//    // Package Level is more restrictive than public
//    void printMessage() {

    @Override
    public void printMessage() {
        System.out.println("Child class");
        super.printMessage();
    }

    void otherMethodWhichIsTotallyUselessAndIDontKnowWhyIHavePutItHere() {
        System.out.println("A message from otherMethodWhichIsTotallyUselessAndIDontKnowWhyIHavePutItHere method");
    }

    public static void main(String[] args) {
        ParentClass2 pc = new ParentClass2();
        pc.printMessage();

        ParentClass2 childClassActually = new ChildClass();
        childClassActually.printMessage();

//        // Can't do this.
//        pc.otherMethod();

    }
}