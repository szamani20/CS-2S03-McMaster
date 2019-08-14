package basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringJoiner;

public class Strings {
    public Strings() {
//        // String class is immutable, it cannot be changed once it has
//        // been created.
//        String s1 = "Hello";
//        // Here Java creates another string object with the content
//        // "Hi" and the reference to it is assigned to s1 instance
//        s1 = "Hi";
//        // Therefore if you change the string content a lot, you
//        // better use the StringBuffer which is mutable and thread-safe
//        // (or StringBuilder if not doing multi-threaded code)
//        StringBuffer sb = new StringBuffer("Hello");
//        sb.append(" World!");
//        System.out.println(sb);
//
//        char[] characters = new char[]{'H', 'e', 'l', 'l', 'o'};
//        char[] characters2 = {'H', 'e', 'l', 'l', 'o'};
//        String s2 = new String(characters);
//        String s3 = new String(characters2);
//        String s4 = new String("Hello");
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);

//        // let's dive into examples of useful String methods
//        stringMethods1();

//        // let's analyze the performance of StringBuffer
//        stringMethods2();

//        // let's work with date
//        stringDateExample();

//        // let's work with ascii
//        stringASCIIExample();

//        // StringJoiner is useful too
//        stringJoinerExample();
    }

    private void stringJoinerExample() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        sj.add("Me");
        sj.add("And");
        sj.add("The");
        sj.add("Boys");

        System.out.println(sj);
    }

    private void stringASCIIExample() {
        // ASCII code for A is 65
        int[] codes = {65, 66, 67, 68};
        for (int code : codes)
            System.out.println(Character.toString((char)code));
    }

    private void stringDateExample() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String dateString = "12/08/2019";
        String dateString2 = "12-08-2019 20:16:23";

        try {
            Date d1 = df.parse(dateString);
            Date d2 = df2.parse(dateString2);

            System.out.println(d1);
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println();

        Date today = new Date();

        String date1 = df.format(today);
        String date2 = df2.format(today);

        System.out.println(date1);
        System.out.println(date2);
    }

    private void stringMethods2() {
        String s1 = "HELLO";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            if (i % 2 == 0)
                s1 = s1.concat(getSaltString());
            else s1 = s1.substring(0, 5);
        }
        System.out.println(System.currentTimeMillis() - t1);


//        // StringBuilder is the non-synchronized (non-thread-safe)
//        // version of StringBuffer. So we use it instead
//        StringBuilder sb = new StringBuilder("HELLO");
//        long t2 = System.currentTimeMillis();
//        for (int i = 0; i < 50000000; i++) {
//            if (i % 2 == 0)
//                sb.append(getSaltString());
//            else sb.delete(5, 12);
//        }
//        System.out.println(System.currentTimeMillis() - t2);
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    private void stringMethods1() {
        // two leading space and one trailing space
        String university = "  McMaster ";
        String university2 = "McMaster";
        String university3 = "McMaster McMaster";
        String first = "hell no";
        String second = "hello";

        System.out.println(university);
        System.out.println(university.length());
        System.out.println(university.charAt(0));
        System.out.println(university.charAt(1));
        System.out.println(university.charAt(2));

        System.out.println(university2.equalsIgnoreCase("mcmaster"));

        // Compares the unicode of the two strings character by
        // character, until reaching the difference
        System.out.println(second.compareTo(first));

        System.out.println(university.startsWith(" "));
        System.out.println(university2.indexOf("M"));
        // We can specify starting position to look for the character
        System.out.println(university3.indexOf("r", 8));

        System.out.println(university2.substring(2, 5));
        System.out.println(university2.substring(2));

        university2 = university2.concat(" University");
        System.out.println(university2);

        // Undo the concatenation
        university2 = university2.replace(" University", "");
        System.out.println(university2);

        System.out.println(university2.toUpperCase());

        String universities = String.join(", ", university2,
                "Waterloo", "Ryerson", "Western Ontario", "York");
        System.out.println(universities);

        // The split method accepts a Regex (Regular Expression) as its
        // argument
        String[] unis = universities.split(", ");
        System.out.println(unis[0]);
        System.out.println(unis[2]);

        System.out.println();

        // String format() method is very useful for structuring
        // string, especially when you want to display something

        System.out.println(String.format("University: %s", "McMaster"));

        // Multiple arguments
        System.out.println(String.format
                ("First arg: %1$s again %1$s and second arg: %2$s",
                        "Hello", "Bonjur"));

        // Format the left padding
        System.out.println(String.format("Left padding @%05d", 23));
        System.out.println(String.format("Left padding @%5s", "23"));

        // Format the right padding
        System.out.println(String.format("Right padding %-5d@", 23));
        System.out.println(String.format("Right padding %-5s@", "23"));

        // Format the digits in fractional part
        System.out.println(String.format("%.6f", 23.24));

        // Omitting the leading and trailing white spaces
        System.out.println("  McMaster    ".trim());

        // Convert int or other numerical to string
        System.out.println(String.valueOf(23));

        // And finally the match() method which works with regex
        System.out.println("McMaster University".
                matches("(.*)University")); // Anything ends with University
    }

    public static void main(String[] args) {
        new Strings();
    }
}
