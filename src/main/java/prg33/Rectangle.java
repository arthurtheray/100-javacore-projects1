package prg33;

public class Rectangle implements Shape {

    private final double a;
    private final double b;
    private final String name = "Rectangle";

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSquare() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * a * b;
    }

    @Override
    public String getName() {
        return name;
    }
}
