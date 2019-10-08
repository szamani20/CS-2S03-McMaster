/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
An Exception is an event that interrupts the normal flow of the program.
There are several cases for an exception to be thrown:
Opening a non-existing file in your program, Network connection problem,
bad input data provided by user, division by zero etc.

Exception is different from Error. When an error occurs, the program
should crash. There is no handling for error.

There are two types of exception in Java: Checked and Unchecked exception
Checked exceptions are compile time exceptions (in opposition with
runtime exception). If they are not handled explicitly using a
try-catch block or throws keyword, they prevent the
program compilation. IOException, ClassNotFoundException etc. are checked.
Unchecked exceptions are runtime exceptions. They are not checked at compile
time. The programmer should be aware of them and handle them properly.
NullPointerException, ArithmeticException etc. are unchecked.

finally block can also be added at the end of catch clauses (or even
right after a try block with no catch block) and should
contain crucial code that must be executed after the try-catch block
finally finishes execution (either successfully or through and exception)
Even if try block returns , the finally block will be executed.
The death of thread or System.exit() may prevent execution of
a finally block.
 */

package exceptionhandling;

import java.io.IOException;
import java.io.*;

public class TryCatch {
    public TryCatch() {
//        try {
//            // We must put the call to a method with throws keyword
//            // inside a try-catch block or another method which also
//            // throws that exception (or its parents)
//            handleCheckedException();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println("First statement of try block");
//            int num = 23 / 0;
//            System.out.println("No way! " + num);
//            // Exception is not caught
//            // but first the finally block is executed
//            // and then the program crashes
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("ArrayIndexOutOfBoundsException");
//        } finally {
//            System.out.println("finally block");
//        }
//
//        // Let's also look at try-with-resources
//        try {
//            tryWithResourcesExample();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Look at this tricky example
//        System.out.println(trickyFinally());

//        // And this one too
//        try {
//            return;
//        } finally {
//            System.out.println("Haha!");
//        }
    }

    private void tryWithResourcesExample() throws FileNotFoundException {
        // Old Java 7 style
        try (FileOutputStream fileOutputStream = new FileOutputStream("ttt.txt");) {
            String content = "We are writing this line in the output file.";
            byte[] binaryContent = content.getBytes();
            fileOutputStream.write(binaryContent);
            System.out.println("The given String is written in the file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // New Java 9 style
        FileOutputStream fileOutputStream = new FileOutputStream("ttt.txt");
        try(fileOutputStream){
            String content = "We are writing this line in the output file.";
            byte[] binaryContent = content.getBytes();
            fileOutputStream.write(binaryContent);
            System.out.println("The given String is written in the file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int trickyFinally() {
        // Which one?
        // return inside finally block is not a good practice tho
        try {
            return 23;
        } finally {
            return 24;
        }
    }

    private void handleCheckedException() throws IOException {
        // This code reads the file.txt character by character
        FileInputStream fis = new FileInputStream("./file.txt");
        int k;

        while ((k = fis.read()) != -1)
            System.out.print((char) k);
        fis.close();
    }

    // try-catch block are used for exception handling.
    public static void main(String[] args) {
//        int num1 = 23, num2 = 0;
//        try {
//            num1 /= num2;
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        // Let's add a broader catch block in case of the first catch
//        // block fails to handle the exception
//        catch (Exception e) {
//            // Exception is the super class of all of the exception classes
//            // This is not a good practice. It makes the debugging harder.
//            System.out.println(e.getMessage() + " something");
//        }


        // We may also have nested try-catch blocks
        // Not a good practice anyway
        try {
            //Child try block1
            try {
                System.out.println("block1");
                int b = 24 / 0;
                System.out.println("Nothing here! " + b);
            } catch (ArithmeticException e1) {
                System.out.println("e1");
            }
            //Child try block2
            try {
                System.out.println("block2");
                int b = 42 / 0;
                System.out.println(b);
            }
            // The following catch block cannot catch the ArithmeticException
            // happened in the above try block
            // Therefore JVM looks for the incoming catch blocks (if any)
            // to see if this exception can be caught
            catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("e2");
            }
            System.out.println("Another message here");
        } catch (ArithmeticException e3) { // Caught here
            System.out.println("Arithmetic Exception");
            System.out.println("1");
        } catch (ArrayIndexOutOfBoundsException e4) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("2");
        } catch (Exception e5) {
            System.out.println("Exception");
            System.out.println("3");
        }
        System.out.println("Final message to see if all of the exceptions caught");

        ///////////////////////////////////////////////////////////////
        new TryCatch();

    }
}
