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
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.lenX = lenX;
        this.lenY = lenY;
    }

    public Rectangle(int lenX, int lenY) {
        this(0, 0, lenX, lenY);
    }

    public int getSquare() {
        return this.lenX * this.lenY;
    }

    public int getPerimeter() {
        return (lenX + lenY) * 2;
    }

    public boolean containsPoint(int x, int y) {
        return (x >=  pivotX) && (x <= pivotX + lenX) && (y >= pivotY) && (y <= pivotY + lenY);
    }
}
