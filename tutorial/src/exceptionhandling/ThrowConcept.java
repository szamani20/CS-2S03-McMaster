/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Built-in exceptions like ArithmeticException are defined to be thrown
upon certain events. We may also throw an exception in other cases as well.
For example division by zero is illegal normally. In our program we may also
forbid division by 23 and throw an exception whenever that happens.
We may also define our own exception class e.g. DivideByTwentyThreeException

Note the difference between throw and throws.
When you throw an exception your program must catch it or it will crash
When you throws an exception you are telling that this method *might* "throw"
that exception when executing (but not for sure)
 */

package exceptionhandling;

public class ThrowConcept {
    public ThrowConcept(int age, String university)
            throws CustomCheckedException, UnnecessaryException {
//        if (age < 23)
//            throw new ArithmeticException("Not eligible");
//        else System.out.println("OK");

//        // Let's try our custom (checked) exception
//        if (university.toLowerCase().contains("waterloo"))
//            throw new CustomCheckedException("Bad");
//
        // Now trying custom unchecked exception
        tryUncheckedException(age);
    }

    // Notice that with unchecked exception we don't need throws keyword
    // in method signature
    private void tryUncheckedException(int age) {
        if (age < 23)
            throw new CustomUncheckedException("Not eligible!");
    }

    public static void main(String[] args) {
        try {
            new ThrowConcept(22, "Waterloo");
        }
        // This is valid syntax to shorten the catch claus chain
        catch (CustomCheckedException | UnnecessaryException e) {
            e.printStackTrace();
            System.out.println("Hello");
        }
    }
}

class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}

// Exception itself extends Throwable
class UnnecessaryException extends Throwable {
    public UnnecessaryException(String message) {
        super(message);
    }
}
