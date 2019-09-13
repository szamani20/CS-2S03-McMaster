/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package oop;/*
The process by which one class acquires the properties i.e. data members and
functionalities i.e. methods of another class is called inheritance.

Inheritance is known as IS-A relationship between child and parent class
 */


public class Inheritance extends Parent {

    /*
    Constructor of subclass is invoked when we create an object of it (obviously)
    It by default invokes the DEFAULT constructor of super class
    We can explicitly call the superclass constructor via keyword super()
    It must be the first statement in the subclass constructor.
     */
    public Inheritance(String name) {
//        // Can't put anything before super
//        System.out.println("Child Constructor");
        super(name);
        System.out.println("Child Constructor");
    }

//    // We can't have any constructor with different signatures from its
//    // parent, unless the parent has a default constructor
//    public Inheritance(int id) {
//
//    }

    public static void main(String[] args) {
        new Inheritance("RUN!");
    }
}

class Parent {
    public Parent(String name) {
        System.out.println("Parent Constructor");
    }

//    public Parent() {
//
//    }
}

class Teacher {
    String role = "Instructor";
    String organization = "McMaster";

    protected void does() {
        System.out.println("Teaching");
    }

    protected void practical(int uselessArgument) {
        System.out.println("Maybe!");
    }

}

// A CS Teacher IS A Teacher
class CSTeacher extends Teacher {
    String subject = "Computer Science";

    public static void main(String[] args) {
        CSTeacher cst = new CSTeacher();

        // Child data
        System.out.println(cst.subject);

        // Parent data (Which can also be overridden if not private)
        System.out.println(cst.role);
        System.out.println(cst.organization);

        // Parent functionality (Can be overridden if not private)
        cst.does();

        // We have overridden the practical() method
        cst.practical(23);
    }

    @Override
    protected void practical(int uselessArgument) {
//        // We may or may not call the parent version of the method
//        super.practical(uselessArgument);
        System.out.println("For a CS teacher? Absolutely!");
    }
}
