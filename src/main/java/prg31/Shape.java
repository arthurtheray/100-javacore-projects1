package prg31;

public abstract class Shape {

    private final String colour;

    public Shape(String colour) {
        this.colour = colour;
    }

    public abstract double getSquare();
    public abstract double getPerimeter();

    public String getColour() {
        return colour;
    }
}
