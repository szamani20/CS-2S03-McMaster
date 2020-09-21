/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
By using streams we can perform various aggregate operations on the
data returned from collections, arrays, Input/Output operations.
stream() method returns a stream of all elements of a collection
so if you apply a method on each element, it will be executed
in parallel.
Parallel execution of operations using stream is faster
than sequential execution without using streams.

How to:
1. Create a stream using stream() method
2. Perform an intermediate operation which transform the stream into
another stream. filter() method for example. Multiple operations
may be applied to streams.
3. Perform a terminal operation to get the final result. count()
for example.

aggregate functions do not change the data. Stream operations are
"lazy". They are not executed until the moment of need. No preliminary
calculation or process.
 */

package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcept {
    public StreamConcept() {
//        streamExample1();
//        streamExample2();
        streamExample3();
    }

    private void streamExample3() {
        Student s1 = new Student("Cyrus", "The Great", 2500);
        Student s2 = new Student("Alexander", "The other Great", 2300);
        Student s3 = new Student("Abbas", "Great Again", 500);
        Student s4 = new Student("Alfred", "Great!", 1200);
        Student s5 = new Student("Reza", "the Great", 100);
        Student s6 = new Student("Shapur", "First Great", 1800);
        Student s7 = new Student("Constantine", "Tha Greata", 1700);
        Student s8 = new Student("Ramesses", "pGreat", 2200);
        Student s9 = new Student("Ivan", "отличный", 500);

        List<Student> kings = new ArrayList<>();
        kings.add(s1);
        kings.add(s2);
        kings.add(s3);
        kings.add(s4);
        kings.add(s5);
        kings.add(s6);
        kings.add(s7);
        kings.add(s8);
        kings.add(s9);

        Predicate<Student> old = king -> king.age > 2000;
        Predicate<Student> russians = king -> !king.name.toLowerCase().contains("great");
        Predicate<Student> allGreat = king -> king.id.toLowerCase().contains("отличный") ||
                king.id.toLowerCase().contains("great");
        // All will die, great and non-great.
        Predicate<Student> alive = king -> king.age < 100;

        System.out.println(kings.stream().anyMatch(old));
        System.out.println(kings.stream().anyMatch(russians));
        System.out.println(kings.stream().allMatch(allGreat));
        System.out.println(kings.stream().noneMatch(alive));
        System.out.println();

        List<Student> oldOnes = kings.stream().filter(
                king -> king.age > 1000
        ).collect(Collectors.toList());
        oldOnes.forEach(System.out::println);
        System.out.println();

        List<Student> oldAndLongName = kings.stream().filter(
                king -> king.age > 1000 &&
                        king.name.length() > 10
        ).collect(Collectors.toList());
        oldAndLongName.forEach(System.out::println);
        System.out.println();

        // Make great kings' names GREAT
        kings.stream().forEach(king -> king.name = king.name.toUpperCase());
        kings.forEach(System.out::println);
        System.out.println();

        Double kingAgeAverage = kings.stream().collect(Collectors.averagingInt(
                king -> king.age
        ));
        System.out.println(kingAgeAverage);
    }

    private void streamExample2() {
        // Starts from 1, does the unary operation adding in each iteration
        // Filter out numbers divisible by 3
        // Do it until maximum 6 results are produced
        // For each of them the final operation would be printing it
        Stream.iterate(1, count -> count + 1)
                .filter(number -> number % 3 == 0)
                .limit(6)
                .forEach(System.out::println);
    }

    private void streamExample1() {
        List<String> realms = new ArrayList<>();
        realms.add("United Kingdom");
        realms.add("Canada");
        realms.add("Australia");
        realms.add("New Zealand");
        realms.add("Sri Lanka");
        realms.add("Bermuda");
        realms.add("Jamaica");
        realms.add("And a lot more");

        int bigRealms = 0;
        for (String realm : realms)
            if (realm.length() > 7)
                bigRealms++;
        System.out.println("Big Realms: " + bigRealms);

        long bigRealmsStreamWay = realms.stream().filter(realm -> realm.length() > 7).count();
        System.out.println("Big Realms: " + bigRealmsStreamWay);
    }

    class Student {
        String name;
        String id;
        int age;

        public Student(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        new StreamConcept();
    }
}
