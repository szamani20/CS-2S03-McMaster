package oop;

/*
Simply, the idea of encapsulation is to hide the implementation details
from users. Also known as data hiding.
It improves maintainability, flexibility, and re-usability.
It also ensures for read-only properties (no setters, only getters)
 */
public class Encapsulation {
    public static void main(String[] args) {
        PersonEnc person = new PersonEnc();
        person.setName("Geronimo");
        person.setCarBrand("Cadillac");
        person.setSin(1234567890);
    }
}

class PersonEnc {
    private int sin;
    private String name;
    private String carBrand;

    public int getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}


