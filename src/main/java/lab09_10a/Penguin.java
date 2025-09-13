package lab09_10a;

public class Penguin extends Bird implements Swimable {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void makeNest() {
        System.out.println("Penguin made a nest.");
    }

    @Override
    public void swim(){
        System.out.println("Swimming like a Penguin!");
    }
}
