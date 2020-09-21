/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package oop;

public class Main {
    // We may have different constructors with different arguments
    // If no constructor is defined explicitly, the default constructor
    // is used by Java compiler

    // Constructors cannot be abstract, final, static. They cannot
    // return anything, unlike methods.

    int id;
    String name;

    public Main() {

    }

    public Main(int id, String name) {
        // this keyword refers to the object itself. The object which its code
        // is being executed.
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main(23, "McMaster");
    }
}
