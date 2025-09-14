package project_abstract_factory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

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

        new Thread(() -> {
            try {
                Thread.sleep(333);
                System.out.println("[BG] did something probably important");
            } catch (InterruptedException ignored) {
            }
        }).start();

        animal(Species.DOG, "Rex");
        animal(Species.CAT, "Mittens");
        animal(Species.RABBIT, "Flopsy");

        for (Animal animal : animals) {
            animal.speak();
            if (animal instanceof Dog) {
                System.out.println(animal.name + " chases tail.");
            } else if (animal instanceof Cat) {
                System.out.println(animal.name + " ignores you.");
            } else if (animal instanceof Rabbit) {
                System.out.println(animal.name + " nibbles something?");
            } else {
                System.out.println(animal.name + " does animal stuff.");
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
        DogFactory dogFactoty = new DogFactory();
        IAnimal dog = dogFactoty.makeAnimal("Buddy");
        k.setDogs((Dog) dog);
    }

    static void animal(Species species, String name) {

        switch (species) {
            case DOG -> {
                IAnimalFactory dogFactory = new DogFactory();
                IAnimal dog = dogFactory.makeAnimal(name);
                animals.add((Animal) dog);
                break;
            }
            case CAT -> {
                IAnimalFactory catFactory = new CatFactory();
                IAnimal cat = catFactory.makeAnimal(name);
                animals.add((Animal) cat);
                break;
            }
            case RABBIT -> {
                IAnimalFactory rabbitFactory = new RabbitFactory();
                IAnimal rabbit = rabbitFactory.makeAnimal(name);
                animals.add((Animal) rabbit);
                break;
            }
            default -> {
                System.out.println("Animal is not valid!");
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

// Abstract Factory Interface
interface IAnimalFactory {

    IAnimal makeAnimal(String name);
}

// Concrete Factory for Dog
class DogFactory implements IAnimalFactory {

    @Override
    public IAnimal makeAnimal(String name) {
        return new Dog(name);
    }
}

// Concrete Factory for Cat
class CatFactory implements IAnimalFactory {

    @Override
    public IAnimal makeAnimal(String name) {
        return new Cat(name);
    }
}

// Concrete Factory for Rabbit
class RabbitFactory implements IAnimalFactory {

    @Override
    public IAnimal makeAnimal(String name) {
        return new Rabbit(name);
    }
}

// Abstract Actions Interface for Animal
interface IAnimal {

    void speak();

    void move();

    void eat(String food);
}

// Concrete Animal for Animal Interface
class Animal implements IAnimal {

    protected String name;
    protected int legs;

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;

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
        super(name, 4);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: woof");
    }

}

// Inhereted Cat from Animal 
class Cat extends Animal {

    public Cat(String name) {
        super(name, 4);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: meow");
    }

}

// Inhereted Rabbit from Animal 
class Rabbit extends Animal {

    public Rabbit(String name) {
        super(name, 4);
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
