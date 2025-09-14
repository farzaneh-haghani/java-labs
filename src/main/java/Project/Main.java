package Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Animal> animals = new ArrayList<>();

    enum Species {
        DOG, CAT, RABBIT, UNKNOWN
    }

    enum Countries {
        UK, FR
    }

    enum Status {
        OK, WARN, TODO
    }

    public static void main(String[] args) {
        System.out.println("=== Starter App ===");

        IAnimal dog = AnimalFactory.makeAnimal(Species.DOG, "Rex");
        animals.add((Animal) dog);
        IAnimal cat = AnimalFactory.makeAnimal(Species.CAT, "Mittens");
        animals.add((Animal) cat);
        IAnimal rabbit = AnimalFactory.makeAnimal(Species.RABBIT, "Flopsy");
        animals.add((Animal) rabbit);

        for (Animal animal : animals) {
            animal.speak();
            if (animal instanceof Dog) {
                System.out.println(animal.getName() + " chases tail.");
            } else if (animal instanceof Cat) {
                System.out.println(animal.getName() + " ignores you.");
            } else if (animal instanceof Rabbit) {
                System.out.println(animal.getName() + " nibbles something?");
            } else {
                System.out.println(animal.getName() + " does animal stuff.");
            }

            animal.move();
            animal.eat("food");
            System.out.println();
        }

        double bill = calculateTax(123.45, Countries.UK);
        System.out.println("Tax rough calc: " + bill);

        saveAnimalsToFile("animals.json");

        System.out.println("Report:");
        printReport(Arrays.asList(Status.OK, Status.WARN, Status.TODO));

        Kennel k = new Kennel();
        Dog myDog = (Dog) AnimalFactory.makeAnimal(Species.DOG, "Buddy");

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(333);
                concurrentSetDog(k, myDog);
            } catch (InterruptedException ignored) {
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }

    // Thread safe method to set the dog in the kennel list
    static synchronized void concurrentSetDog(Kennel k, Dog dog) throws InterruptedException {
        k.setDogs(dog);
        System.out.println("[BG] did something probably important");
    }

    // Simple factory class
    static class AnimalFactory {

        static IAnimal makeAnimal(Species species, String name) {

            switch (species) {
                case DOG -> {
                    return new Dog(name);
                }
                case CAT -> {
                    return new Cat(name);
                }
                case RABBIT -> {
                    return new Rabbit(name);
                }
                default -> {
                    System.out.println("Animal is not valid!");
                    return null;
                }
            }
        }
    }

    static double calculateTax(double gross, Countries country) {
        if (Countries.UK.equals(country)) {
            return gross * 0.2;
        }
        if (Countries.FR.equals(country)) {
            return gross * 0.19 + 3;
        }
        return gross * 0.15;
    }

    public static void saveAnimalsToFile(String path) {
        System.out.println("Saving to " + path + " ...");
    }

    static void printReport(List<Status> lines) {
        System.out.println("---- REPORT ----");
        for (int i = 0; i < lines.size(); i = i + 1) {
            System.out.println((i + 1) + ") " + lines.get(i));
        }
        System.out.println("Generated at: " + LocalDateTime.now());
    }
}

// Simple factory interface
interface IAnimal {

    void speak();

    void move();

    void eat(String food);
}

// Concrete Animal for Animal Interface
class Animal implements IAnimal {

    protected String name;
    protected int legs;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println(name + " moves somehow on " + legs + " legs.");
    }

    @Override
    public void eat(String food) {
        System.out.println(name + " eats " + food + ".");
    }

    @Override
    public void speak() {
    }
}

// Inhereted Dog from Animal 
class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: woof");
    }

}

// Inhereted Cat from Animal 
class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: meow");
    }

}

// Inhereted Rabbit from Animal 
class Rabbit extends Animal {

    public Rabbit(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: squeak");
    }

}

class Kennel {

    private final List<Dog> dogs = new ArrayList<>();

    public void setDogs(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

}
