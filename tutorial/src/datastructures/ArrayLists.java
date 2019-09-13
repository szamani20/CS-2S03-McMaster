/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Arrays:
Java arrays are the most basic data collection in java. Fixed length,
a little faster in some cases and harder to work with comparing to ArrayList.
Most of the time we prefer ArrayLists over traditional arrays

ArrayList:
A class that implements List interface and is more like a traditional array
except that it is not fixed length and has a lot of methods in it which makes
manipulation of data much easier. They are still basic and based on the
needs of program, the developer should decide whether they want to use
another data structure or not.

 */

package datastructures;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayLists {
    public ArrayLists() {
//        arrayListExample();
//        arrayListExample2();
//        arrayListExample3();
        arrayListCheckEfficiency();
    }

    // Basic operations
    private void arrayListExample() {
        List<String> provinces = new ArrayList<>();

        provinces.add("Quebec");
        provinces.add("Alberta");
        provinces.add("Manitoba");
        provinces.add("British Columbia");

        for (String province:provinces)
            System.out.println(province);
        System.out.println();

        // I want Ontario to be the first one
        provinces.add(0, "Ontario");

        for (String province:provinces)
            System.out.println(province);
        System.out.println();

        provinces.remove("Manitoba");
        provinces.remove(3);

        for (String province:provinces)
            System.out.println(province);
        System.out.println();

        provinces.set(2, "Northwest Territories");

        for (String province:provinces)
            System.out.println(province);
        System.out.println();

        System.out.println(provinces.get(2));
        System.out.println(provinces.indexOf("Quebec"));
        System.out.println(provinces.size());
        System.out.println(provinces.contains("Alberta"));
        System.out.println();

//        provinces.clear();
//        System.out.println(provinces.size());

        provinces.add("Alberta");
        provinces.add("British Columbia");
        Collections.sort(provinces);

        for (String province:provinces)
            System.out.println(province);
        System.out.println();
    }

    // ArrayList of custom objects and how to sort them
    private void arrayListExample2() {
        University McMaster = new University("McMaster", true);
        University Waterloo = new University("Waterloo", false);
        University McGill = new University("McGill", true);
        University Toronto = new University("Toronto", true);
        University UdeM = new University("UdeM", false);

        List<University> universities = new ArrayList<>();
        universities.add(McMaster);
        universities.add(Waterloo);
        universities.add(McGill);
        universities.add(Toronto);
        universities.add(UdeM);

        // Let's see how sorting a List of custom objects works

        // This is the inline way of doing so. We define a way
        // to compare two objects of type University
        // We use lambda expression, a Java 8 syntax here
        Collections.sort(universities, (o1, o2) -> {
            if (o1 == null || o2 == null)
                return 0;
            // If both are good or both are bad, sort by their name
            if ((o1.good && o2.good) || (!o1.good && !o2.good))
                return o1.name.compareToIgnoreCase(o2.name);
            else if (!o1.good && o2.good)
                return 1;
            else
                return -1;

        });
        for (University university:universities)
            System.out.println(university.name);
        System.out.println();

//        // Another option is to let the University class implements
//        // the Comparable interface. Technically, these two ways
//        // are similar, except that in the inline method we do not
//        // need to explicitly implement the Comparable interface
//        Collections.sort(universities);
//        for (University university:universities)
//            System.out.println(university.name);
//        System.out.println();

    }

    // Advanced operations in ArrayList
    private void arrayListExample3() {
        // We may define an ArrayList with initial size for memory
        // efficiency reasons. It could be expanded later on
        // automatically when adding new elements
        ArrayList<String> provinces = new ArrayList<>(2);
        provinces.add("Ontario");
        provinces.add("Quebec");
        provinces.add("Alberta");
        provinces.add("Manitoba");
        provinces.add("Northwest Territories");
        provinces.add("British Columbia");

        List<String> countries = new ArrayList<>();
        countries.add("UK");
        countries.add("Canada");
        countries.add("Australia");
        countries.add("New Zealand");

//        // Sublist of ArrayList
//        List<String> subList = new ArrayList<>(provinces.subList(1, 3));
//        for (String province : subList)
//            System.out.println(province);
//        System.out.println();

//        // Swapping two elements of ArrayList
//        Collections.swap(provinces, 2, 4);
//        for (String province : provinces)
//            System.out.println(province);
//        System.out.println();

//        // Joining two ArrayList (of same types)
//        provinces.addAll(countries);
//        for (String provinceOrCountry : provinces)
//            System.out.println(provinceOrCountry);
//        System.out.println();


//        /*
//        ArrayLists are actually arrays with fixed initial size
//        that will expand its size whenever that initial size filled
//        with elements.
//            int newCapacity = oldCapacity + (oldCapacity >> 1);
//            elementData = Arrays.copyOf(elementData, newCapacity);
//        It's a good practice, when working with big ArrayLists, to trim
//        the additional capacity off the memory when we are sure that
//        rarely a new item will be added.
//        There is also ensureCapacity() method that is useful when we
//        try to add a huge amount of elements to an ArrayList. Without
//        that method the ArrayList must be extended several times, but
//        with ensureCapacity() this happens only once.
//         */
//        ArrayList<Integer> bigArrayList = new ArrayList<>();
//        bigArrayList.ensureCapacity(1000000);
//        for (int i = 0; i < 1000000; i++)
//            bigArrayList.add(i);
//        // Now the reserved size may be far more than 1000000
//        // So we can trim the additional space out
//        bigArrayList.trimToSize();

//        // With clone method we can make a copy of an ArrayList items
//        // into another ArrayList
//        ArrayList<String> provinceClone = (ArrayList<String>) provinces.clone();
//        provinceClone.add("Prince Edward Island");
//        System.out.println(provinces.size());
//        System.out.println(provinceClone.size());
    }

    private void arrayListCheckEfficiency() {
        ArrayList<Integer> regular = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++)
            regular.add(i);
        System.out.println(System.currentTimeMillis() - t1);

//        ArrayList<Integer> initialSized = new ArrayList<>(10000000);
//        long t2 = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++)
//            initialSized.add(i);
//        System.out.println(System.currentTimeMillis() - t2);
    }

    public static void main(String[] args) {
        new ArrayLists();
    }
}

//class University implements Comparable {
class University {
    String name;
    boolean good;

    public University(String name, boolean good) {
        this.name = name;
        this.good = good;
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o == null)
//            return -1;
//        if (!(o instanceof University))
//            return -1;
//
//        University other = (University) o;
//        if ((other.good && this.good) || (!other.good && !this.good))
//            return this.name.compareToIgnoreCase(other.name);
//        else if (!other.good && this.good)
//            return -1;
//        else return 1;
//    }
}
