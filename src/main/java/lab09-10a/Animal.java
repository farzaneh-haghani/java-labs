package lab09;

public abstract class Animal implements Movable{
    private String name;
    protected AnimalType animalType;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move(){
        System.out.println("Moving like an animal!");
    }
}
