/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
TreeMap is an implementation of Red-Black tree. It has the advantages
of a tree data structure but it is also sorted to the natural ordering
of its keys (by re-structuring every time a node is added)
 */

package datastructures;

import java.util.Map;
import java.util.TreeMap;

public class TreeMaps {
    public TreeMaps() {
        treeMapsExample1();
    }

    private void treeMapsExample1() {
        TreeMap<Float, String> populationToProvince = new TreeMap<>();

        populationToProvince.put(13.4f, "Ontario");
        populationToProvince.put(1.2f, "Manitoba");
        populationToProvince.put(1.1f, "Saskatchewan");
        populationToProvince.put(8.1f, "Quebec");
        populationToProvince.put(4.0f, "Alberta");
        populationToProvince.put(4.6f, "British Columbia");

        for (Map.Entry entry : populationToProvince.entrySet())
            System.out.println(entry.getValue() + ": " + entry.getKey());
        System.out.println();

        // TreeMap has almost all of the common operations in HashMap
        // class and we won't cover them again
        // Just analyze your problem during programming and decide
        // which Map data structure works better in your case
    }

    public static void main(String[] args) {
        new TreeMaps();
    }
}
