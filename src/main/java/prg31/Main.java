package prg31;

/**
 * Наследование: `Shape` → `Circle/Rectangle`.
 *    1. Требования: базовый класс абстрактный; без `instanceof`.
 *    2. Теория: наследование, абстрактные классы/методы, полиморфизм.
 */
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("red", 10);
        Shape rectangle = new Rectangle("blue", 6, 3);
        System.out.println(circle.getColour());
        System.out.println(rectangle.getPerimeter());
    }
}
