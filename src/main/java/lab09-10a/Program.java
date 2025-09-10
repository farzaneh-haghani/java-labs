package lab09;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        Animal fish = new Fish("fish");
        Animal duck = new Duck("duck");
        Animal penguin = new Penguin("penguin");
        animals.add(fish);
        animals.add(duck);
        animals.add(penguin);

        for (Animal animal : animals) {
            System.out.println(animal.getName());
            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }
            if (animal instanceof Swimable) {
                ((Swimable) animal).swim();
            }
        }
    }
}
