package prg32;

/**
 * Интерфейс `Drawable`. `draw()` (текстовый вывод).
 *    1. Требования: интерфейс обязателен; без абстрактных классов.
 *    2. Теория: интерфейсы, реализация несколькими классами, контракт интерфейса.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.draw("У котика " + cat.getNumberOfPaws() + " лапок");
    }
}
