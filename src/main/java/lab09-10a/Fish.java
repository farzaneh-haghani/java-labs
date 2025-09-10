package lab09;

public class Fish extends Animal implements Swimable {
    public Fish(String name) {
        super(name);
        this.animalType = AnimalType.Fish;
    }

    @Override
    public void swim() {
        System.out.println("Swimming like a fish!");
    }
}
