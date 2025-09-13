package lab09_10a;

public class Duck extends Bird implements Flyable, Swimable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void makeNest() {
        System.out.println("Duck made a nest.");
    }

    @Override
    public void fly() {
        System.out.println("Flying like a Duck!");
    }

    @Override
    public void swim() {
        System.out.println("Swimming like a Duck!");
    }
}
