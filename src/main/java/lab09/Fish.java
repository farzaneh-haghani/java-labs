package lab09;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
        this.animalType = AnimalType.Fish;
    }

    public void swim() {
        System.out.println("Fish is swimming...");
    }
}
