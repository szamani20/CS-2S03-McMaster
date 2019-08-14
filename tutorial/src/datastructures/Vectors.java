/*
Vectors are mostly like ArrayLists but unlike ArrayLists
they are multi-thread friendly as they are synchronized.
Therefore, they give poor performance on most of the regular operations
on Lists.
 */

package datastructures;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Vectors {
    public Vectors() {
        Vector<String> vec = new Vector<>();

        // We may define the initial capacity and capacity increment
        Vector vec2 = new Vector(5, 2);

        vec.add("Ontario");
        vec.addElement("Quebec");
        System.out.println(vec.capacity());
        System.out.println(vec2.capacity());

        Enumeration e = vec.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
        System.out.println();

        // Iterator is similar to Enumeration except that you can also
        // remove the element when Iterating
        Iterator i = vec.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        System.out.println();
    }

    public static void main(String[] args) {
        new Vectors();
    }
}
