package prg22;

/**
 * Объект представляющий собой прямоугольник со следующими характеристиками: базовая точка, длина по Y, длина по Y.
 * Базовая точка - левый нижний угол прямоугольника
 */
public class Rectangle {
    private final int pivotX;
    private final int pivotY;
    private final int lenX;
    private final int lenY;

    public Rectangle(int pivotX, int pivotY, int lenX, int lenY) {
        if (lenX == 0 || lenY == 0) {
            throw new IllegalArgumentException("длина и ширина не должны быть нулевыми");
        }
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.lenX = lenX;
        this.lenY = lenY;
    }

    public Rectangle(int lenX, int lenY) {
        this(0, 0, lenX, lenY);
    }

    public int getSquare() {
        return abs(this.lenX * this.lenY);
    }

    public int getPerimeter() {
        return (abs(lenX) + abs(lenY)) * 2;
    }

    public boolean containsPoint(int x, int y) {
        return isBetween(x, this.pivotX, this.pivotX + lenX)
                && isBetween(y, this.pivotY, this.pivotY + lenY);
    }

    private int abs(int value) {
        return value >= 0 ? value : value * -1;
    }

    private boolean isBetween(int value, int firstLimit, int secondLimit) {
        int min;
        int max;
        if (firstLimit <= secondLimit) {
            min = firstLimit;
            max = secondLimit;
        } else {
            min = secondLimit;
            max = firstLimit;
        }
        return value >= min && value <= max;
    }
}
