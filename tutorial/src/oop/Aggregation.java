package oop;/*
Aggregation is a directional association relationship between two classes
A one-way association that represents a HAS-A relationship.
 */

public class Aggregation {
    public static void main(String[] args) {
        Address address1 = new Address(23, "Main St. West",
                "Hamilton", "Ontario");
        Student student1 = new Student("William", "McMaster Jr.");

        // HAS-A relationship
        student1.setAddress(address1);

        // IS-A relationship
        student1.setSin(1234567890);

        System.out.println(student1.getStudentInfo());
    }
}

class Address {
    private int stNum;
    private String stName;
    private String city;
    private String province;

    Address(int stNum, String stName, String city, String province) {
        this.stNum = stNum;
        this.stName = stName;
        this.city = city;
        this.province = province;
    }

    @Override
    public String toString() {
        return stNum + " " + stName + " " + city + " " + province;
    }
}

class Person {
    private int sin;
    private String name;
    private String surName;

    Person(int sin, String name, String surName) {
        this.sin = sin;
        this.name = name;
        this.surName = surName;
    }

    // In case the person doesn't have a SIN
    Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public int getSin() {
        return sin;
    }

    void setSin(int sin) {
        this.sin = sin;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}

// A student IS A Person and HAS A(n) Address
class Student extends Person {
    private Address address;

    public Student(int sin, String name, String surName) {
        super(sin, name, surName);
    }

    Student(String name, String surName) {
        super(name, surName);
    }

    Address getAddress() {
        return address;
    }

    void setAddress(Address address) {
        this.address = address;
    }

    String getStudentInfo() {
        return this.getName() + " " + this.getSurName() +
                " " + this.getSin() + " " + this.getAddress();
    }
}
