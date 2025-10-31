package prg33;

public class Sphere implements Shape {

    private final double radius;
    private final String name = "Sphere";

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return name;
    }
}
