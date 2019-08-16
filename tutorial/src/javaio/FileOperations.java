package javaio;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class FileOperations {
    public FileOperations() {
//        deleteFileExample();
//        compressFileExample();
        copyFileContent();
    }

    private void copyFileContent() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File inFile = new File("test.txt");
            File outFile = new File("testCopy.txt");

            fis = new FileInputStream(inFile);
            fos = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0)
                fos.write(buffer, 0, length);

            fis.close();
            fos.close();

            System.out.println("Copied successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void compressFileExample() {
        byte[] buffer = new byte[1024];
        try {
            GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream("text.gz"));

            FileInputStream fis = new FileInputStream("test.txt");

            int length;
            while ((length = fis.read(buffer)) > 0)
                gos.write(buffer, 0, length);

            fis.close();
            gos.finish();
            gos.close();

            System.out.println("File compressed successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFileExample() {
        File file = new File("toDelete.txt");

        if (file.delete())
            System.out.println(file.getName() + " deleted successfully");
        else System.out.println("Nothing to delete");
    }

    public static void main(String[] args) {
        new FileOperations();
    }
}
