package CTDL.Homework_5;

public class Rectangle {
    //  _____________
    //  |           |
    //  |           | width
    //  |           |
    //  -------------
    //      height
    private String id;
    private Point a; // represent (bot, left)
    private Point b; // represent (top, right)

    public Rectangle(String id, Point a, Point b) {
        this.id = id;
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public double getWidth() {
        return b.x - a.x;
    }

    public double getHeight() {
        return b.y - a.y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ": (" + getWidth() + " " + getHeight() + ")";
    }
}
