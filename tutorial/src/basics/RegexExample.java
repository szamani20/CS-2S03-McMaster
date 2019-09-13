/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
Regular expressions are used for defining String patterns that can
be used for searching, manipulating and editing a text.
Regex has a ton of rules and mastering all of them is not an
obligation for everyday use. There are multiple methods to learn
regex rules, but our approach here is by example.
*/

package basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public RegexExample() {
        example1();
//        example2();
    }

    private void example2() {
        System.out.println(Pattern.matches("mcmaster", "McMaster"));
        System.out.println(Pattern.matches("[Mm]c[Mm]aster", "mcMaster"));
        System.out.println();
        // No number at the beginning
        System.out.println(Pattern.matches("^[^\\d].*", "2McMaster"));
        System.out.println(Pattern.matches("^[^\\d].*", "McMaster2"));
        System.out.println();
        // Only and only three letters
        System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aB2"));
        System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aBC"));
        System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aBCd"));
        System.out.println();

        // Only digits
        System.out.println(Pattern.matches("\\d*", "abc"));
        System.out.println(Pattern.matches("\\d*", "213c"));
        System.out.println(Pattern.matches("\\d*", "213"));
        System.out.println();

        // Only non-digits
        System.out.println(Pattern.matches("\\D*", "ab2"));
        System.out.println(Pattern.matches("\\D*", "ab"));
        System.out.println();

        // Starts with McMaster
        System.out.println(Pattern.matches("^McMaster", "McMaster cool"));
        // Ends with McMaster
        System.out.println(Pattern.matches("McMaster$", "Cool McMaster"));
        // Starts and ends with McMaster --> Exactly McMaster
        System.out.println(Pattern.matches("^McMaster$", "McMaster"));
        System.out.println(Pattern.matches("^McMaster$", "mcmaster"));
        System.out.println();

        // Starts with McMaster
        System.out.println(Pattern.matches("^McMaster.*", "McMaster cool"));
        // Ends with McMaster
        System.out.println(Pattern.matches(".*McMaster$", "Cool McMaster"));
        // Starts and ends with McMaster --> Exactly McMaster
        System.out.println(Pattern.matches("^McMaster$", "McMaster"));
        System.out.println(Pattern.matches("^McMaster$", "mcmaster"));
        System.out.println();
    }

    void example1() {
        String content1 = "This is Soroush from the McMaster university";
        // Zero or more characters before or after McMaster
        String pattern1 = ".*McMaster.*";

        // content1 contains McMaster?
        // matches() method searches for pattern in content
        System.out.println(Pattern.matches(pattern1, content1));

        String pattern2 = ".*mcmaster.*";
        // For case sensitivity we use compile() method
        Pattern compiledPattern = Pattern.compile(pattern2, Pattern.CASE_INSENSITIVE);
        System.out.println(compiledPattern.matcher(content1).matches());

        String content2 = "Me,And,The,Boys";
        Pattern compiledSplitPattern = Pattern.compile(",", Pattern.CASE_INSENSITIVE);
        String[] parts = compiledSplitPattern.split(content2);
        for (String part : parts)
            System.out.print(part + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new RegexExample();
    }
}
