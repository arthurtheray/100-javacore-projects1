package prg31;

public class Rectangle extends Shape {

    private final double lenX;
    private final double lenY;

    public Rectangle(String colour, double lenX, double lenY) {
        super(colour);
        this.lenX = lenX;
        this.lenY = lenY;
    }

    @Override
    public double getSquare() {
        return lenX * lenY;
    }

    @Override
    public double getPerimeter() {
        return 2 * lenX * lenY;
    }
}
