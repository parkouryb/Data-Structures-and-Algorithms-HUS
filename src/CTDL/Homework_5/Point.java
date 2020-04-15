package CTDL.Homework_5;

public class Point {
    public double x;
    public double y;

    // modified: x...z,aa (',' equals '.')
    public Point(double x, double y) {
        this.x = Math.round(x * 100.0) / 100.0;
        this.y = Math.round(y * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
