package lab07;

import java.awt.Color;
import java.awt.Point;

public class Sphere extends Circle {

    public Sphere(Color colour, Point position, Double radius) {
        super(colour, position);
        super.setRadius(radius);
    }

    public Double getVolumn() {
        Double radius = super.getRadius();
        return 4 / 3 * Math.PI * Math.pow(radius, 3);
    }

    public String printCharacteristics() {
        return String.format("The sphere with %.2f radius has %.2f volumn.", super.getRadius(), getVolumn());
    }
}
