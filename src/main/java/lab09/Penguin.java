package lab09;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void makeNest() {
        System.out.println("Penguin made a nest.");
    }
}
