/*
Serialization is a mechanism to convert an object into stream of bytes
so that it can be written into a file, transported through a network
or stored into database.
It happens by implementing the Serializable interface which makes
all non-transient fields of the class able to be written into a file
after being converted to stream of bytes.
 */

package advanced;

import java.io.*;

public class Serialization {
    public Serialization() {
//        serialize();
        deserialize();
    }

    private void deserialize() {
        Student std = null;
        try {
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            std = (Student) ois.readObject();

            // These two should be in finally block but ok for now.
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(std.getStdID());
        System.out.println(std.getStdName());
        System.out.println(std.getStdAge());
        // It doesn't print the correct value, since that field
        // is transient and is not serialized.
        System.out.println(std.getStdHeight());
    }

    private void serialize() {
        Student std = new Student("111-111-111",
                23, "Soroush", 183);
        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(std);

            // These two should be in finally block but ok for now.
            oos.close();
            fos.close();

            System.out.println("Serialization done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Serialization();
    }
}

// No method in Serializable interface to be implemented
class Student implements Serializable {
    private String stdID;
    private int stdAge;
    private String stdName;
    // Not that important to write into file
    private transient int stdHeight;

    public Student(String stdID, int stdAge, String stdName, int stdHeight) {
        this.stdID = stdID;
        this.stdAge = stdAge;
        this.stdName = stdName;
        this.stdHeight = stdHeight;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdHeight() {
        return stdHeight;
    }

    public void setStdHeight(int stdHeight) {
        this.stdHeight = stdHeight;
    }
}
