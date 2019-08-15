/*
The reason we have default methods in interfaces is to allow the developers to
add new methods to the interfaces without affecting the classes that implements
these interfaces.
For example, if several classes implements an interface then if we add a
new method to the interface, we have to change the code in all the
classes that implements this interface.

Default methods can be added to any existing interface and we do not need to
implement these methods in the implementation classes necessarily, thus we
can add these default methods to existing interfaces without breaking the code.

Static methods in interfaces follow the same concept except that they cannot
be overridden at all (unlike default methods that may be overridden)

Interfaces can still provide full abstraction. Default method is an option and
doesn't make Interface like Abstract class. They still have differences.
 */
package advanced;

public class InterfaceDefaultMethods implements InterfaceWithDefaultMethod {
    public InterfaceDefaultMethods() {
        this.newMethod();
        this.existingMethod();

        InterfaceWithDefaultMethod.staticMethod();
    }

    public static void main(String[] args) {
        new InterfaceDefaultMethods();
    }

    @Override
    public void existingMethod() {
        System.out.println("Existing method");
    }

//    // Unable to override this
//    @Override
//    public void staticMethod() {
//
//    }

//    // We may also override a default method too
//    @Override
//    public void newMethod() {
//
//    }
}

interface InterfaceWithDefaultMethod {
    default void newMethod() {
        System.out.println("This method is new");
    }

    static void staticMethod() {
        System.out.println("This cannot be overridden!");
    }

    void existingMethod();
}
