/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
package javaio;

import java.io.*;

public class FileManipulation {
    public FileManipulation() {
//        createFileExample();
//        writeToFileExample();
//        appendToFileExample();
        readFileExample();
    }

    private void appendToFileExample() {
        String appendContent = ", Canada";
        File file = new File("test.txt");

        try {
            if (!file.exists())
                file.createNewFile();

            // true for appending
            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(appendContent);
            bw.close();

            System.out.println("Appended successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFileExample() {
        FileOutputStream fos = null;
        File file;
        String content = "Department of Computing and Software, McMaster University, Hamilton, Ontario";

        try {
            file = new File("test.txt");
            fos = new FileOutputStream(file);

            // We already did this anyway
            if (!file.exists())
                file.createNewFile();

            // String content cannot be directly written into file
            byte[] binaryContent = content.getBytes();

            fos.write(binaryContent);
            fos.flush();
            System.out.println("Successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void readFileExample() {
        File file = new File("test.txt");
        BufferedInputStream bis = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            while (bis.available() > 0)
                System.out.print((char) bis.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null && fis != null) {
                    fis.close();
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createFileExample() {
        try {
            File file = new File("test.txt");
            boolean fileCreated = file.createNewFile();
            if (fileCreated)
                System.out.println("File created successfully");
            else System.out.println("File already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileManipulation();
    }
}
