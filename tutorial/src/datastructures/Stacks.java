/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Stack is a data structure based on Last-In First-Out policy (LIFO).
It is implemented in JDK by extending the Vector class.
Stacks are used a lot in CPU design and Programming Language design
 */

package datastructures;

import java.util.Stack;

public class Stacks {
    public Stacks() {
        Stack<String> registers = new Stack<>();

        registers.push("R1");
        registers.push("R2");
        registers.push("R3");
        registers.push("R4");

        System.out.println(registers.peek());
        System.out.println(registers.pop());
        System.out.println(registers.pop());
        System.out.println(registers);
        System.out.println(registers.search("R2"));
    }

    public static void main(String[] args) {
        new Stacks();
    }
}
