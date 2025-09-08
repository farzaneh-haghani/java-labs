package lab07;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

class Program {
    public static void main(String[] args) {
        Shape circle = new Circle(Color.RED, new Point(0, 0));
        ((Circle) circle).setRadius(2.5);

        Shape rectangle = new Rectangle(Color.BLUE, new Point(5, 5), 10.0, 5.5);
        Shape sphere = new Sphere(Color.GREEN, new Point(10, 10), 10.5);

        String shapeInfo;
        shapeInfo = ((Circle) circle).printCharacteristics();
        System.out.println(shapeInfo);

        shapeInfo = ((Rectangle) rectangle).printCharacteristics();
        System.out.println(shapeInfo);

        shapeInfo = ((Sphere) sphere).printCharacteristics();
        System.out.println(shapeInfo);

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(sphere);

        for (Shape shape : shapes) {
            System.out.printf("The shape %s with %s colour is in the position of %.2f and %.2f.\n",
                    shape.getClass().getSimpleName(),
                    shape.getColour(), shape.getPosition()[0], shape.getPosition()[1]);
        }
    }
}