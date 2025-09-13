package lab09_10a;

public abstract class Bird extends Animal {
    public Bird(String name) {
        super(name);
        this.animalType = AnimalType.Bird;
    }

    public abstract void makeNest();
}
