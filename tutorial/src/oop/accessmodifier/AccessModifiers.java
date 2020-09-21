/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Access modifiers are used to ensure encapsulation and protection
of data and functionality of each class in Java.
Generally, it's the best practice to keep as much as possible of data
and functionality private and only keep those that are necessary for
program to work public. However, this should not increase the coupling
between classes too much as it is again a bad practice.
There are 4 access modifiers: default, private, public, protected
The default access modifier also known as package scope has no keyword
 */

/*
------------+-------+---------+--------------+--------------+--------
            | Class | Package | Subclass     | Subclass     |Outside|
            |       |         |(same package)|(diff package)|Class  |
————————————+———————+—————————+——————————----+—————————----—+————————
public      | Yes   |  Yes    |    Yes       |    Yes       |   Yes |
————————————+———————+—————————+—————————----—+—————————----—+————————
protected   | Yes   |  Yes    |    Yes       |    Yes       |   No  |
————————————+———————+—————————+————————----——+————————----——+————————
default     | Yes   |  Yes    |    Yes       |    No        |   No  |
————————————+———————+—————————+————————----——+————————----——+————————
private     | Yes   |  No     |    No        |    No        |   No  |
------------+-------+---------+--------------+--------------+--------
 */

package oop.accessmodifier;

public class AccessModifiers {
    public AccessModifiers() {
        AnotherClass ac = new AnotherClass();
        // accessible only in the same package
        System.out.println(ac.packageLevelVariable);
        // accessible by everyone
        System.out.println(ac.publicVariable);
        // accessible in the same package AND in the child classes
        System.out.println(ac.protectedVariable);
//        // accessible only by the holder class
//        System.out.println(ac.privateVariable);
    }

    public static void main(String[] args) {
        new AccessModifiers();
    }
}
