/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
ArrayDequeue is a concrete implementation of the Dequeue interface
(alongside with LinkedList). ArrayDequeue is like a Double Queue
in which items could be added or removed from both sides.
 */

package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeue {
    public ArrayDequeue() {
        Deque<String> twoWayLineUp = new ArrayDeque<>();

        twoWayLineUp.add("Person 1");
        twoWayLineUp.add("Person 2");
        twoWayLineUp.offer("Person 3");
        twoWayLineUp.add("Person 4");
        twoWayLineUp.add("Person 5");
        twoWayLineUp.offer("Person 6");
        twoWayLineUp.add("Person 7");

        System.out.println(twoWayLineUp);
        System.out.println(twoWayLineUp.peek());
        System.out.println(twoWayLineUp.peekFirst());
        System.out.println(twoWayLineUp.getFirst());
        System.out.println(twoWayLineUp.peekLast());

        System.out.println(twoWayLineUp.pollFirst());
        System.out.println(twoWayLineUp);
        System.out.println(twoWayLineUp.pollLast());
        System.out.println(twoWayLineUp);
    }

    public static void main(String[] args) {
        new ArrayDequeue();
    }
}
