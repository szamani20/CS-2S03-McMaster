/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Mostly like HashMaps except that they are thread safe. Manipulating
a HashMap in a multi threaded environment will throw exception
but that's not the case with HashTable
 */
package datastructures;

import java.util.Hashtable;

public class HashTables {
    public HashTables() {
        hashTableExample1();
    }

    private void hashTableExample1() {
        Hashtable<String, String> provinceToCapital = new Hashtable<>();

        provinceToCapital.put("Quebec", "Quebec City");
        provinceToCapital.put("Ontario", "Toronto");
        provinceToCapital.put("Alberta", "Edmonton");
        provinceToCapital.put("British Columbia", "Victoria");
        provinceToCapital.put("Manitoba", "Winnipeg");
        provinceToCapital.put("Saskatchewan", "Regina");

        System.out.println(provinceToCapital);
        System.out.println();

        provinceToCapital.remove("Manitoba");
        System.out.println(provinceToCapital);
    }

    public static void main(String[] args) {
        new HashTables();
    }
}
