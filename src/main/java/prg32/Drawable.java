package prg32;

/**
 * Интерфейсов для классов, которые можно нарисовать любым способом (допускается текстовый вывод)
 */
public interface Drawable {
    /**
     * Нарисовать объект;
     */
    void draw(String drawingOptions);
}
