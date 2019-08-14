/*
Simple set of objects. Literally like a set in mathematics.
No duplicates, no order over items. It doesn't even remain constant
over time. The main advantage is that it retrieves an item in O(1),
constant time. That's because a hash table is the backbone of this
data structure.
 */

package datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSets {
    public HashSets() {
//        hashSetExample1();
        hashSetExample2();
    }

    private void hashSetExample1() {
        HashSet<String> provinces = new HashSet<>();

        provinces.add("Quebec");
        provinces.add("Ontario");
        provinces.add("Manitoba");
        provinces.add("Alberta");
        provinces.add("British Columbia");
        provinces.add("Saskatchewan");
        // Duplicate, will replace the old one.
        provinces.add("Quebec");

        // This happens in O(1)
        System.out.println(provinces.contains("Quebec"));

        System.out.println(provinces);
    }

    private void hashSetExample2() {
        // Let's check the contains() method speed in HashSet
        // and compare it to that of the regular ArrayList

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            if (i == 3000000) {
                list.add("Ontario");
                continue;
            }
            list.add(getSaltString());
        }
        long t1 = System.currentTimeMillis();
        System.out.println(list.contains("Ontario"));
        System.out.println(System.currentTimeMillis() - t1);

//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < 10000000; i++) {
//            if (i == 3000000) {
//                set.add("Ontario");
//                continue;
//            }
//            set.add(getSaltString());
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println(set.contains("Ontario"));
//        System.out.println(System.currentTimeMillis() - t2);
    }

    private String getSaltString() {
        // I deleted O so it can't generate Ontario
        String SALTCHARS = "ABCDEFGHIJKLMNPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static void main(String[] args) {
        new HashSets();
    }
}
