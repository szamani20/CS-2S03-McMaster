/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package javaio;

import java.io.File;
import java.text.SimpleDateFormat;

public class AdvancedOperations {
    public AdvancedOperations() {
//        getLastModifiedDataExample();
//        makeFileReadOnlyExample();
        checkHiddenExample();
    }

    /*
    On UNIX for example a file is considered to be hidden if its name
    begins with a period character (‘.’). On Windows a file is
    considered hidden if it isn’t a directory and the DOS
    hidden attribute is set
     */
    private void checkHiddenExample() {
        File file = new File(".test.txt");

        if (file.isHidden())
            System.out.println("Hidden!");
        else System.out.println("Not hidden!");
    }

    private void makeFileReadOnlyExample() {
        File file = new File("test.txt");

        // Let's check if it's read-only
        if (file.canWrite())
            System.out.println("Writeable");
        else System.out.println("Read only");

        boolean madeReadOnly = file.setReadOnly();
        if (madeReadOnly)
            System.out.println("Successful");
        else System.out.println("Not successful");

        // Let's check again
        if (file.canWrite())
            System.out.println("Writeable");
        else System.out.println("Read only");

        file.setWritable(true);
        if (file.canWrite())
            System.out.println("Writeable");
        else System.out.println("Read only");
    }

    private void getLastModifiedDataExample() {
        File file = new File("test.txt");
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(date.format(file.lastModified()));
    }

    public static void main(String[] args) {
        new AdvancedOperations();
    }
}
