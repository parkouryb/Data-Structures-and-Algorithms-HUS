package CTDL.Homework_1;

public class SphereExample{
    public static void main(String[] agrs) {
        Sphere x = new Sphere(0, 0, 0, 4);
        Sphere y = new Sphere(0, 0, 5, 3);
        
        System.out.println(x.surfaceAreaSphere() + " - " + x.volumeSphere());
        System.out.println(x.isInside(y) + " - " + y.isInside(x));
        System.out.println(x.isIntersects(y) + " - " + y.isIntersects(x));
        
    }
}