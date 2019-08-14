package oop;/*
Let's explain by an example. The Animal class has a sound() method. But since
every animal has its own specific sound, it is pointless to implement the
sound() method in the parent Animal class. So we define it as abstract
i.e. no implementation, just the method signature and will implement them
concretely in the subclasses.
 */

public class AbstractConcept {

}

// An abstract class cannot be instantiated
abstract class AbstractAnimal {
    // An abstract cannot be implemented
    public abstract void sound();

    // Cuteness is the concrete
    // Since an abstract class could have non-abstract methods, it does
    // not provide full abstraction. Interfaces provide full abstraction
    private boolean isCute() {
        System.out.println("Concretely!");
        return true;
    }
}

class Dog extends AbstractAnimal {

    // If the child class is not abstract itself, it must implement all
    // abstract methods of the parent class
    @Override
    public void sound() {
        System.out.println("Woof");
    }

    public static void main(String[] args) {
        AbstractAnimal animal = new Dog();
        animal.sound();
    }
}
