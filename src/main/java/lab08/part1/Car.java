package lab08.part1;

public class Car {
    private String model;
    private int speed;

    public Car(String model) {
        this.model = model;
    }

    public int accelerate(int seconds) {
        speed += 5 * seconds;
        return speed;
    }

    public String getModel() {
        return this.model;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void getToSixty() {
        this.speed = 60;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
