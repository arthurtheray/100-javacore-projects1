package prg21;

/**
 * Класс `Point2D`. Поля `x,y`, методы расстояния/сдвига.
 *    1. Требования: инкапсуляция с геттерами/сеттерами; `toString` обязателен.
 *    2. Теория: ООП: инкапсуляция, `this`, `toString`, `Math.hypot`.
 */
public class Main {
    public static void main(String[] args) {
        Point2D firstPoint = new Point2D();
        Point2D secondPoint = new Point2D();
        firstPoint.setX(10);
        firstPoint.setY(15);
        secondPoint.setY(20);
        secondPoint.setX(5);
        System.out.println(firstPoint);
        System.out.println("расстояние между точками " + firstPoint + " и " + secondPoint + " :"
                + getDistance(firstPoint, secondPoint));
        firstPoint.move(3, 5);
        System.out.println("расстояние между точками " + firstPoint + " и " + secondPoint + " :"
                + getDistance(firstPoint, secondPoint));
    }

    private static double getDistance(Point2D firstPoint, Point2D secondPoint) {
        return Math.hypot(firstPoint.getX() - secondPoint.getX(), firstPoint.getY() - secondPoint.getY());
    }
}
