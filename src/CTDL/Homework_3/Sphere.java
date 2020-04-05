package CTDL.Homework_3;

public class Sphere extends Shape {
    private double radius = 0;
    private final double PI = 3.14159;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return (4.0 * PI * Math.pow(this.radius, 3)) / 3.0;
    }

    @Override
    protected double getArea() {
        return 4.0 * PI * Math.pow(this.radius, 2);
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return "Sphere [radius=" + radius + "]";
    }

    
}