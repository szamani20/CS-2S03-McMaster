/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
A unit test is a piece of code written by a developer that executes a
specific functionality in the code to be tested and asserts a certain
behavior or state.
The percentage of code which is tested by unit tests is typically called test coverage.

@Before: used to initialize a resource before testing is actually run
@After: used to deallocate resources that were initialized in the @Before

We predetermine some inputs and their corresponding output and then check
the program against them.

Input:
T=45 d=10 t=40 D=20
T=45 d=10 t=40 D=21
T=45 d=10 t=42 D=21
Output:
500
505
480
 */
package basics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UnitTesting {
    private int s;
    private String t;
    private String d;
    private String T;
    private String D;
    private List<String> list;
    private Scanner in;

    private String input = "T=45 d=10 t=40 D=20";
    private String output = "500";

//    private String input = "T=45 d=10 t=40 D=21";
//    private String output = "505";

//    private String input = "T=45 d=10 t=42 D=21";
//    private String output = "480";

    public UnitTesting() {
        initializeVars();
        scanInput();
        processInput();
        assignOutput();
        printOutput();
        closeResources();
    }

    @Before
    void initializeVars() {
        System.out.println("@Before: initializing the list");
        list = new ArrayList<>();

        assertNotNull(list);
    }

    @Before
    void scanInput() {
        System.out.println("@Before: populating the list");

        in = new Scanner(System.in);
        for (int i = 0; i < 4; i++)
            list.add(in.next());

    }

    @Test
    void processInput() {
        for (int i = 0; i < 4; i++) {
            //check the first character of each element in the list and get t, T, d, D as String
            if (list.get(i).substring(0, 1).equals("t")) {
                t = list.get(i).substring(2);
            } else if (list.get(i).substring(0, 1).equals("T")) {
                T = list.get(i).substring(2);
            } else if (list.get(i).substring(0, 1).equals("d")) {
                d = list.get(i).substring(2);
            } else if (list.get(i).substring(0, 1).equals("D")) {
                D = list.get(i).substring(2);
            }
        }

        // "T=45 d=10 t=40 D=20"
        assertEquals(T, "45");
        assertEquals(d, "10");
        assertEquals(t, "40");
        assertEquals(D, "20");
    }

    @Test
    void assignOutput() {
        if (Integer.parseInt(T) < Integer.parseInt(t))
            s = Integer.parseInt(T) * Integer.parseInt(d);
        else
            s = Integer.parseInt(t) * Integer.parseInt(d) + (Integer.parseInt(T) - Integer.parseInt(t)) * Integer.parseInt(D);

        assertEquals(s, 500);
    }

    @After
    private void closeResources() {
        in.close();
        list.clear();


        // There is no assert method to check for a closed scanner yet
        // but if it were, we should check that here
        // Same for an empty list
    }

    void printOutput() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new UnitTesting();
    }
}
