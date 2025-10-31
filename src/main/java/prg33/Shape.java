package prg33;

/**
 * Интерфейс двухмерной геометрической фигуры
 */
public interface Shape {
    /**
     * @return площадь фигуры
     */
    double getSquare();

    /**
     * @return периметр фигуры
     */
    double getPerimeter();

    String getName();
}
