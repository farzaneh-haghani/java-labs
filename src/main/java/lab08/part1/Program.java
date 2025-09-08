package lab08.part1;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("Benz");
        Car car2 = new Car("BMW");
        Car car3 = new RacingCar("Benz", "person1", 5);
        Car car4 = new RacingCar("Benz", "person2", 10);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        ProcessCars(cars);
    }

    public static void ProcessCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.getToSixty();
            car.accelerate(2);
            if (car instanceof RacingCar) {
                System.out.printf("The racing car is model %s has the speed of %d, driver is %s, turboFactor %d.\n",
                        car.getModel(), car.getSpeed(), ((RacingCar) car).getDriver(),
                        ((RacingCar) car).getTurboFactor());
            } else {
                System.out.printf("The car is model %s has the speed of %d.\n", car.getModel(), car.getSpeed());
            }
        }
    }
}
