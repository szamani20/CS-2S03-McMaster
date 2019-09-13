/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Actually Queue is an interface in Java and we should use a concrete
class that implements it in order to take advantage of the queue
concept.
We have already seen one example of queue, LinkedList. As it had
poll() and peek() methods implemented from the Queue interface.
PriorityQueues work on the basis of First-In First-Out or FIFO policy.
Sometimes we need a priority instead of hard FIFO policy. Think of
senior citizens in a bus line-up. Then we should use PriorityQueue,
another concrete implementation of the Queue interface.
 */
package datastructures;

import java.util.PriorityQueue;

public class PriorityQueues {
    public PriorityQueues() {
        Person p1 = new Person("p1", (short) 12);
        Person p2 = new Person("p2", (short) 34);
        Person p3 = new Person("p3", (short) 66);
        Person p4 = new Person("p4", (short) 23);
        Person p5 = new Person("p5", (short) 78);
        Person p6 = new Person("p6", (short) 85);
        Person p7 = new Person("p7", (short) 11);

        PriorityQueue<Person> lineUp = new PriorityQueue<>();
        // offer() is same as add() just from different interfaces
        // that the PriorityQueue implements
        lineUp.add(p1);
        lineUp.offer(p2);
        lineUp.add(p3);
        lineUp.add(p4);
        lineUp.offer(p5);
        lineUp.add(p6);
        lineUp.add(p7);

        while (lineUp.size() != 0)
            System.out.println(lineUp.poll().name);
    }

    public static void main(String[] args) {
        new PriorityQueues();
    }
}

// With Comparable interface we define the "Natural" order of an object
// Sometimes we might want to sort a collection of objects not based
// on the natural order but with another policy. We can user Comparator
// interface and define as many order as we want.
class Person implements Comparable {
    String name;
    // Life is too short to waste an integer to fit in!
    private short age;

    Person(String name, short age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null)
            return -1;
        short otherAge = ((Person) o).age;

        if ((this.age >= 65 && otherAge >= 65) || (this.age < 65 && otherAge < 65))
            return 0;
        else if (this.age >= 65)
            return -1;
        else return 1;
    }
}
