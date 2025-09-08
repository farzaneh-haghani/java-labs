package lab07;

import java.awt.Color;
import java.awt.Point;

public class Shape {
    private Color colour;
    private Point position;

    public Shape(Color colour, Point position) {
        this.colour = colour;
        this.position = position;
    }

    public String getColour() {
        if (this.colour.equals(Color.RED)) {
            return "red";
        } else if (this.colour.equals(Color.BLUE)) {
            return "blue";
        } else {
            return "green";
        }
    }

    public Object[] getPosition() {
        Double x = position.getX();
        Double y = position.getY();
        return new Object[] { x, y };
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

}