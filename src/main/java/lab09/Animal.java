package lab09;

public abstract class Animal {
    private String name;
    protected AnimalType animalType;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
