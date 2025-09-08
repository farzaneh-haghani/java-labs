package lab07;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
    protected Double radius;

    public Circle(Color colour, Point position) {
        super(colour, position);
    }

    public Double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public Double getCircumference() {
        return Math.PI * getDiameter();
    }

    public Double getDiameter() {
        return 2 * radius;
    }

    public Double getRadius() {
        return this.radius;
    }

    public String printCharacteristics() {
        return String.format("The circle with %.2f radius has %.2f area and %.2f circumference.", radius, getArea(),
                getCircumference());
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}