package CTDL.Homework_1;

public class Sphere {
    private double x, y, z; // toa do
    private double r; // ban kinh
    public static double PI = 3.14159;

    public Sphere() {
    }

    public Sphere(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public double surfaceAreaSphere() {
        return 4.0 * PI * this.r * this.r;
    }

    public double volumeSphere() {
        return (4.0 * PI * this.r * this.r * this.r) / 3.0;
    }

    private double distance(Sphere y) {
        return Math.sqrt( (this.x - y.x) * (this.x - y.x) + 
        (this.y - y.y) * (this.y - y.y) + (this.z - y.z) * (this.z - y.z) );
    }

    private double distance(Sphere a, Sphere b) {
        return Math.sqrt( (a.x - b.x) * (a.x - b.x) + 
        (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z) );
    }

    public boolean isInside(Sphere x) {
        double dist = distance(x, new Sphere(this.x, this.y, this.z, this.r));
        return dist + this.r < x.r;
    }
    
    public boolean isIntersects(Sphere x) {
        double dist = distance(x, new Sphere(this.x, this.y, this.z, this.r));
        System.out.println("ss: " + dist + " : " + x.r + " : " + this.r);
        return dist < x.r + this.r && (dist > this.r && dist > x.r);
    }

    @Override
    public String toString() {
        return "("+ this.x + ", " + this.y + ", " + this.z + ") - r = " + this.r;
    }
}