/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
HashMaps are used to store key-value pairs which is a Map based
collection. There is no order in storing the pairs. Similar to
HashTables but non-synchronized (operations are not performed safely
when working in a multi threaded program).
 */

package datastructures;

import java.util.*;

public class HashMaps {
    public HashMaps() {
        hashMapExample1();
    }

    private void hashMapExample1() {
        Map<String, Float> provinceToPopulationMillion = new HashMap<>();
        // HashMap doesn't allow duplicates, the old value will be
        // overwritten
        provinceToPopulationMillion.put("Ontario", 13.4f);
        provinceToPopulationMillion.put("Quebec", 8.1f);
        provinceToPopulationMillion.put("British Columbia", 4.6f);
        provinceToPopulationMillion.put("Alberta", 4.0f);
        provinceToPopulationMillion.put("Manitoba", 1.2f);
        provinceToPopulationMillion.put("Saskatchewan", 1.1f);

        // As we mentioned, there is no order!
        for (String key : provinceToPopulationMillion.keySet())
            System.out.println(key + ": " + provinceToPopulationMillion.get(key));
        System.out.println();

        System.out.println(provinceToPopulationMillion.containsKey("Quebec"));
        System.out.println(provinceToPopulationMillion.containsValue(4.0f));
        System.out.println(provinceToPopulationMillion.get("Ontario"));
        System.out.println();

        for (Float populationMillion : provinceToPopulationMillion.values())
            System.out.println(populationMillion);
        System.out.println();

        // Another way to print entries.
        // If you need both keys and values, user entrySet() as the
        // additional call to get() costs more
        for (Map.Entry entry : provinceToPopulationMillion.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        // For sorting, based on your need to sort by key or by value
        // there are different approaches.
        Iterator it = new TreeMap<>(provinceToPopulationMillion).entrySet().iterator();
        // There are more efficient ways
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }

    public static void main(String[] args) {
        new HashMaps();
    }
}
