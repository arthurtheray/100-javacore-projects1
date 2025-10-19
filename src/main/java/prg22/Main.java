package prg22;

/**
 * Класс `Rectangle`. Площадь/периметр, содержит ли точку.
 *    1. Требования: перегрузка конструкторов; запрет статических полей.
 *    2. Теория: перегрузка конструкторов, `this()` вызовы, инварианты класса.
 */
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 5, 10, 10);
        System.out.println("perimeter: " + rectangle.getPerimeter());
        System.out.println("Square: " + rectangle.getSquare());
        System.out.println("rectangle contains point (15, 15): " + rectangle.containsPoint(15, 15));
        System.out.println("rectangle contains point (15, 150): " + rectangle.containsPoint(15, 150));
    }
}
