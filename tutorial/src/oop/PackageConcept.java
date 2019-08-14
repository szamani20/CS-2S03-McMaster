package oop;

import oop.dummypackage.DummyClass; // Import a single property from package
// * is called wildcard
import oop.dummypackage.*; // Import the whole package (BUT not the subpackages)

/*
A package is basically a directory (folder) which mainly contains Java classes,
Interfaces, and other packages.
There are a lot of built-in packages in Java:
java.util.List
java is top level package, util is sub package, List is the class
We may also define our own packages, like the very package we put this code in
We use packages to organize our code for better re-usability and maintenance
 */
public class PackageConcept {
    public static void main(String[] args) {
        // IDEs usually help you to import a package automatically
        // Here we import DummyClass from the dummypackage package
        DummyClass d = new DummyClass();
        // Or we may import everything from the package
        AnotherDummyClass d2 = new AnotherDummyClass();

        // We could also have nested packages
        oop.dummypackage.verydummy.DumbestClass d3 = new oop.dummypackage.verydummy.DumbestClass();

        // A lot of times we have classes with same names in different
        // packages. We need to use the fully qualified name to use the class
        // This way we don't need to import the package
        oop.dummypackage.DumbestClass d4 = new oop.dummypackage.DumbestClass();

        System.out.println(d3.getClass());
        System.out.println(d4.getClass());
    }
}
