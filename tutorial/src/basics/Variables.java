/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package basics;

public class Variables {
    // Any variable defined with the keyword static is considered as static.
    // They are also known as class variables which implies that all objects
    // of this class have access to the very same variable, not different
    // instances of it.
    private static int classVar1;

    // Any other variable defined here is known as an Instance variable
    // Each object has its own copy of instance variables
    private String instanceVar = "Something";


    public Variables() {
        // These are local variables, they are defined within the method of
        // a class, their scope is limited to the method, i.e. you can't access
        // or alter their values outside the method.
        int num;
        int num2 = 2;
        double val1 = 2.2;
        Double val2 = 2.2;
        char ch = 'A';
        String name = "McMaster";

//        // We cannot define a static variable inside a non-static method
//        static String cantDoThat = "Hello!";

//        System.out.println(num);
//        num = 3;
//        System.out.println(num);
//        System.out.println(Integer.toString(num2));
//        System.out.println(Integer.toString(num2) instanceof String);

//        ch = 'a';
//        System.out.println(ch);

//        // There are a lot of methods associated with the String class
//        System.out.println(name.length());
//        System.out.println(name.charAt(2));
//        System.out.println(name.concat(", Hamilton"));

//        // There is no class associated with a primitive value (double, int, etc.)
//        System.out.println(val2.getClass());
//        System.out.println(val1.getClass());

        // Static variable can be accessed within a non-static method
//        classVar1 = 23;
    }

    private static void staticMethod() {
        // We may define non-static variables inside a static method
        String nonStaticString = "Hello!";

        classVar1 = 24;
    }

    private static void alterStaticVariable() {
        classVar1 = 25;
    }

    private void alterInstanceVariable() {
        instanceVar = "Something else";
    }

    public static void main(String[] args) {
//        new Variables();

//        Variables v1 = new Variables();
//        System.out.println(v1.classVar1);
//        System.out.println(classVar1);
//        Variables.alterStaticVariable();
//        System.out.println(v1.classVar1); // Bad practice
//        System.out.println(classVar1);
//        System.out.println(Variables.classVar1);

//        Variables v2 = new Variables();
//        Variables v3 = new Variables();
//        System.out.println(v2.instanceVar);
//        System.out.println(v3.instanceVar);
//        v2.alterInstanceVariable();
//        System.out.println(v2.instanceVar);
//        System.out.println(v3.instanceVar);
    }
}
