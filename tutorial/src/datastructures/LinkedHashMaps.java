/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
LinkedHashMap is a HashTable and LinkedList implementation of Map in
Java. They maintain the insertion order.

So:
HashMap does not maintain any order.
TreeMap sorts the entries in ascending order of keys.
LinkedHashMap maintains the insertion order.
 */

package datastructures;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMaps {
    public LinkedHashMaps() {
        linkedHashMapExample1();
    }

    private void linkedHashMapExample1() {
        LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<>();

        lhmap.put("First", 1);
        lhmap.put("Second", 2);
        lhmap.put("Third", 3);
        lhmap.put("Fourth", 4);
        lhmap.put("Fifth", 5);

        Iterator it = lhmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        // LinkedHashMap has almost all of the common operations
        // in HashMap class and we won't cover them again
        // Just analyze your problem during programming and decide
        // which Map data structure works better in your case
    }

    public static void main(String[] args) {
        new LinkedHashMaps();
    }
}
