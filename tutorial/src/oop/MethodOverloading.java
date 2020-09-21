/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package oop;/*
Method Overloading is a feature that allows a class to have more than one
method having the same name and return type, but different argument lists
Binding of method call to its definition happens at compile time.
 */

public class MethodOverloading {
    public MethodOverloading() {
    }

    // Not the best example logically, but does the job!
    private void display(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);
    }

    private void display(String id, String firstName, String lastName) {
        System.out.println(id + " " + firstName + " " + lastName);
    }

    private void display() {
        System.out.println("No argument provided");
    }

    // This is something else by definition
    private int display(int id) {
        return 2;
    }

    public static void main(String[] args) {
        new MethodOverloading();
    }
}

class TrickyExample {
    void display(int a, double b) {
        System.out.println("Hello 1");
    }

    void display(int a, double b, double c) {
        System.out.println("Hello 2");
    }

//    // This method prevents Type Promotion
//    void display(int a, float b) {
//        System.out.println("Hello 3");
//    }

    public static void main(String args[]) {
        TrickyExample obj = new TrickyExample();

        // The second argument is not a double, it's a float. But no method
        // in this class accepts a float as its second argument.
        // However the float data type could be Promoted to a similar
        // data type with bigger size, i.e. double data type.
        obj.display(100, 20.67f);
    }
}
