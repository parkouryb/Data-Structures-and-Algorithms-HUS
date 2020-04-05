package CTDL.Homework_3;

import java.util.ArrayList;

public class ShapeExample{
    public static void main(String[] agrs) {
        ArrayList<Shape> shapeArray = new ArrayList<Shape>();
        shapeArray.add(new Circle(4));
        shapeArray.add(new Circle(2));
        shapeArray.add(new Rectangle(4,2));
        shapeArray.add(new Sphere(4));
        shapeArray.add(new Circle(1));

        for (Shape x : shapeArray) {
            x.setName(x.getClass().getSimpleName());
            System.out.println(x.toString());    
        }
        System.out.printf("%-10s %-10s %-10s\n", "Area", "Perimeter", "Volume");
        for (Shape x : shapeArray) {
            System.out.printf("%-10.5f %-10.5f %-10.5f\n", x.getArea(), x.getPerimeter(), x.getVolume());
        }
    }
}