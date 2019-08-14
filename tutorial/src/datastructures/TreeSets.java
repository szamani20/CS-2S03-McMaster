/*
Similar to HashSet except that it sorts the elements in ascending
order while HashSet doesn't maintain any order. It's an implementation
of a self-balancing Binary Search Tree.
 */

/*
IMPORTANT:
Choosing of a data structure to store program data in it, mostly depends
on the type of data and their usage and manipulation frequency.
If searching through the data is of high frequency use a HashSet
If adding multiple elements is of high frequency and the ascending
order of data is important use a TreeSet.
...
 */

package datastructures;

import java.util.TreeSet;

public class TreeSets {
    public TreeSets() {
        treeSetExample1();
    }

    private void treeSetExample1() {
        TreeSet<String> sinNumbers = new TreeSet<>();

        sinNumbers.add("000000000");
        sinNumbers.add("222222222");
        sinNumbers.add("111111111");
        sinNumbers.add("444444444");
        sinNumbers.add("333333333");
        sinNumbers.add("777777777");

        System.out.println(sinNumbers);
    }

    public static void main(String[] args) {
        new TreeSets();
    }
}
