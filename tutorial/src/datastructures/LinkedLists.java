/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Unlike ArrayLists where elements are stored in a contiguous array-like
stores, LinkedList items are tied to each other using pointers.
Each element of a LinkedList not only contains the value of that
element, but it also contains a pointer to the next element (and
previous element in case of doubly LinkedLists)

When there are a lot of inserts and deletes in our data, we better
use LinkedList as these operations are very cost effective in LinkedLists
(unlike ArrayLists)

A lot of methods covered in ArrayList tutorial also exists here. We won't
cover them all again.
 */

package datastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {
    public LinkedLists() {
        linkedListExample1();
    }

    private void linkedListExample1() {
        LinkedList<String> family = new LinkedList<>();
        family.add("GrandParent");
        family.add("Parent");
        family.add("Child");
        family.add("GrandChild");

        System.out.println(family);
        System.out.println();

        family.add(2, "Self");

        System.out.println(family);
        System.out.println();

        family.addFirst("Great GrandParent");
        family.addLast("Great GrandChild");

        System.out.println(family);
        System.out.println();

        System.out.println(family.indexOf("Self"));

        // peek() method picks the first element and returns it
        // just like peekFirst() and getFirst() and probably some
        // other methods! These methods are from different superclasses
        // or interfaces extended or implemented by LinkedList
        System.out.println(family.peek());
        System.out.println(family.getFirst());
        System.out.println(family.peekFirst());
        System.out.println(family.peekLast());
        System.out.println();

        // poll() method returns and removes the first item
        // pollFirst() does exactly the same thing! But it is implemented
        // from another interface
        family.poll();
        System.out.println(family);
        family.pollFirst();
        System.out.println(family);
        family.pollLast();
        System.out.println(family);

        // There are also push and pop methods! Guess what do they do!
        // Probably the same thing as many other methods in LinkedList

        // Iterate over LinkedList
        Iterator it = family.listIterator();
        while (it.hasNext()) {
            String elem = (String) it.next();
            System.out.println(elem);
            if (elem.equals("Self"))
                it.remove();
        }
        System.out.println();
        it = family.descendingIterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println();

        // ListIterator also similar to Iterator except that
        // it also has a previous() and hasPrevious() method
        ListIterator li = family.listIterator();
        while (li.hasNext())
            System.out.println(li.next());
        System.out.println();
    }

    public static void main(String[] args) {
        new LinkedLists();
    }
}
