package prg33;

import java.util.ArrayList;
import java.util.List;

/**
 * Фабрика фигур.
 *    1. Требования: статическая фабрика; без `new` вне фабрики.
 *    2. Теория: шаблон Factory Method/Static Factory, инкапсуляция создания.
 */
public class Main {
    public static void main(String[] args) {
        Shape rectangle = ShapesFactory.createRectangle(6, 12);
        Shape sphere = ShapesFactory.createSphere(7);
        List<Shape> shapes = new ArrayList<>();

        shapes.add(rectangle);
        shapes.add(sphere);

        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " perimeter: " + shape.getPerimeter() + "; square: " + shape.getSquare());
        }
    }
}
