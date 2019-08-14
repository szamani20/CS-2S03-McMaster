/*
Just like the ArrayList keeps the ordering of insertion.
But one important difference:
No duplicate item is allowed for the sake of high insertion and search
efficiency.

Again it depends on the type of program, but if the order of insertion
is important and you don't have duplicate items, user a LinkedHashSet.

HashSet doesn't maintain any kind of order of its elements.
TreeSet sorts the elements in ascending order.
LinkedHashSet maintains the insertion order.
 */
package datastructures;

import java.util.LinkedHashSet;

public class LinkedHashSets {
    public LinkedHashSets() {
        linkedHashSetExample1();
    }

    private void linkedHashSetExample1() {
        LinkedHashSet<String> lhset = new LinkedHashSet<>();

        lhset.add("A");
        lhset.add("B");
        lhset.add("C");
        lhset.add("D");
        lhset.add("E");
        lhset.add("F");

        System.out.println(lhset);
    }

    public static void main(String[] args) {
        new LinkedHashSets();
    }
}
