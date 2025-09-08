package lab07;

import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
    private Double sideA;
    private Double sideB;

    public Rectangle(Color colour, Point position, Double sideA, Double sideB) {
        super(colour, position);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Double getArea() {
        return this.sideA * this.sideB;
    }

    public Double getCircumference() {
        return 2 * (this.sideA + this.sideB);
    }

    public String printCharacteristics() {
        return String.format("The rectangle with two sides of %.2f and %.2f has %.2f area and %.2f circumference.",
                sideA, sideB, getArea(), getCircumference());
    }
}
