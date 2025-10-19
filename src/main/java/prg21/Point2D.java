package prg21;

import java.util.Formatter;

public class Point2D {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y) {
        int oldX = this.x;
        int oldY = this.y;
        this.x += x;
        this.y += y;
        System.out.printf("{X: %d -> %d}; {Y: %d -> %d\n}", oldX, this.x, oldY, this.y);
    }

    @Override
    public String toString() {
        return String.valueOf(new Formatter().format("{X=%d}; {Y=%d}", this.x, this.y));
    }
}
