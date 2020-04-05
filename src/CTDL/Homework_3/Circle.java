package CTDL.Homework_3;

public class Circle extends Shape {
    private double radius = 0;
    private final double PI = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 0; 
    }

    @Override
    protected double getArea() {
        return PI * (double)Math.pow(this.radius, 2);
    }

    @Override
    protected double getPerimeter() {
        return PI * 2 * this.radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }


}