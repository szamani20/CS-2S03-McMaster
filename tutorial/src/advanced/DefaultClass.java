/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
This class is introduced to avoid NullPointerException that we
frequently encounters if we do not perform null checks in our code.
Using this class we can easily check whether a variable has null
value or not and by doing this we can avoid the NullPointerException

Optional.ofNullable() method of the Optional class, returns a
Non-empty Optional if the given object has a value, otherwise it
returns an empty Optional.
 */
package advanced;

import java.util.Optional;

public class DefaultClass {
    public DefaultClass() {
//        nullPointerExample();
        optionalClassExample();
        // There are several other methods in Optional class
        // Most of them with similar usage, we won't cover them here
    }

    private void optionalClassExample() {
        String[] strings = new String[10];
        Optional<String> isNull = Optional.ofNullable(strings[3]);

        // It means if that value was not null
        // Anyways, you could have used a simple == null check with the
        // original value.
        if (isNull.isPresent()) {
            String s = strings[3].substring(2, 4);
            System.out.println(s);
        } else System.out.println("Empty string");

        strings[3] = "McMaster";
        Optional<String> isNull2 = Optional.ofNullable(strings[3]);
        if (isNull2.isPresent()) {
            String s = strings[3].substring(2, 4);
            System.out.println(s);
        } else System.out.println("Empty string");
    }

    private void nullPointerExample() {
        String[] strings = new String[10];
        String s = strings[3].substring(2, 4);
        System.out.println(s);
    }

    public static void main(String[] args) {
        new DefaultClass();
    }
}
