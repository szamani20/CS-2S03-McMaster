/*
Method reference is a shorthand notation of a lambda expression
to call a method
Lambda Expression:
str -> System.out.println(str)
Method Reference:
System.out::println

The :: operator is used in method reference to separate the class or
object from the method name

Types of Method Reference:
object::instanceMethod
Class::staticMethod
Class::instanceMethod
Class::new  // Reference to constructor
 */
package advanced;

import java.util.Arrays;

public class MethodReference {
    public MethodReference() {
        methodReferenceType1();

        methodReferenceType3();

        // Other types? pretty similar!
    }

    private void methodReferenceType3() {
        String[] provinces = {"Quebec", "Ontario", "Alberta",
                "British Columbia"};

        Arrays.sort(provinces, String::compareToIgnoreCase);
        for (String province : provinces)
            System.out.println(province);
    }

    private void methodReferenceType1() {
        MyFI3 fi = this::reallyPrintMessage;
        fi.printMessage();
    }

    void reallyPrintMessage() {
        System.out.println("McMaster");
    }

    public static void main(String[] args) {
        new MethodReference();
    }
}

@FunctionalInterface
interface MyFI3 {
    void printMessage();
}
