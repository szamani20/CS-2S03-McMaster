/*
We have final variables, final methods, and final classes in Java.
Generally and inaccurately, final keyword makes a property unchangeable.
 */

package oop;

public class FinalKeyword {
    final int maxAllowd = 24;
    // We may also have blank final variables.
    // They must be initialized in (every) constructor
    final int studentNumber;

    // This must be initialized in static block
    // What's the point? The value can be determined in future.
    static final int something;
    static {
        something = 23;
    }

    // Also a good practice to name final variables in all CAPS
    final String US_PRESIDENT = "TRUMP";

    public FinalKeyword(int studentNumber, String dummy) {
        System.out.println("Hey there!");
        this.studentNumber = studentNumber;
    }

    public FinalKeyword(int studentNumber) {
        this.studentNumber = studentNumber;

//        // Compile error
//        maxAllowd = 23;
    }

    // A final method cannot be overridden
    final void overrideMe() {

    }

    // A final class cannot be extended
    final class ExtendMe {

    }

    public static void main(String[] args) {
        new FinalKeyword(24);
    }

    interface Dummy {
        // Interface variables are public, static, and final by default
        public static final int variable = 23;
    }
}
