/*
Array is divided into sub arrays, each one is sorted separately and in parallel
with others, and then the sorted arrays are merged together. It obviously
uses multithreading to sort sub arrays simultaneously.
 */
package advanced;

import java.util.Arrays;

public class ParallelSort {
    public ParallelSort() {
        int[] ages = {42, 24, 66, 96, 13, 11};
        Arrays.parallelSort(ages);
        Arrays.stream(ages).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new ParallelSort();
    }
}
