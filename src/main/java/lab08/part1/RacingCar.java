package lab08.part1;

public class RacingCar extends Car {
    private String driver;
    private int turboFactor;

    public RacingCar(String model, String driver, int turboFactor) {
        super(model);
        this.driver = driver;
        this.turboFactor = turboFactor;
    }

    public int accelerate() {
        int speed = super.accelerate(turboFactor);
        return speed * turboFactor;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getModel() {
        return super.getModel();
    }

    public int getTurboFactor() {
        return this.turboFactor;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setTurboFactor(int turboFactor) {
        this.turboFactor = turboFactor;
    }
}
