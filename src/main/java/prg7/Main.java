package prg7;

/**
 * Таблица умножения. Вывести 10×10.
 *     1. Требования: двойной `for`; форматированный вывод.
 *     2. Теория: вложенные циклы, счётчики, выравнивание в `printf`.
 */
public class Main {
    public static final int MATRIX_SIZE_X = 10;
    public static final int MATRIX_SIZE_Y = 10;
    public static void main(String[] args) {
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 1; i <= MATRIX_SIZE_Y; i++) {
            for (int j = 1; j <= MATRIX_SIZE_X; j++) {
                System.out.print(i * j + "\t");
                if (j == MATRIX_SIZE_X) {
                    System.out.print("\n");
                }
            }
        }
    }
}
