package prg33;

public class ShapesFactory {

    public static Shape createSphere(double radius) {
        return new Sphere(radius);
    }

    public static Shape createRectangle(double a, double b) {
        return new Rectangle(a, b);
    }
}
