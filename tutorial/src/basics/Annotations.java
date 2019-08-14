/*
Java Annotations allow us to add metadata information into our
source code. They have no direct effect on the execution of operations
they annotate.
They are like instructions to Java compiler and give
it some information about the code. We may have seen @Override
annotation which tells the Java compiler that the method is overridden.
An annotation always starts with @ symbol and it can be applied to
classes, interfaces, methods and fields (variables).
@Override, @Deprecated, @SuppressWarnings are built-in annotations
we already saw @Override, @Deprecated is used to clarify that a part
of Java API is no longer supported (and will probably omitted in
future releases). @SuppressWarnings tells compiler to ignore a warning.
 */

package basics;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class Annotations {

    @SuppressWarnings("deprecation")
    public Annotations() {
        deprecatedMethod();
        testMethod();
    }

    @Deprecated
    void deprecatedMethod() {
        System.out.println("I am deprecated :(");
    }

    @CustomAnnotation(uni="McMaster")
    void testMethod() {
        System.out.println("Does nothing here");
    }

    public static void main(String[] args) {
        new Annotations();
    }
}

@Documented // Elements using this annotation should be documented
@Target(ElementType.METHOD) // Where to use this annotation
@Inherited // Subclasses should also use the annotation (not in this case)
@Retention(RetentionPolicy.SOURCE) // Only available in source code (not in compiled code)
@interface CustomAnnotation {
    int age() default 23;
    String uni();
    String field() default "CS";
}
