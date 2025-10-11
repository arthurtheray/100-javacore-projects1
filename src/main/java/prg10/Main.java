package prg10;

/**
 * Число Фибоначчи. Вычислить n-е число.
 *    1. Требования: итеративно с двумя переменными; без массивов.
 *    2. Теория: последовательности, оптимизация по памяти, базовые и переходные случаи.
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.printf("%s Fibonacci element (including 0) is %s", n, findFiboElement(n));
    }

    private static int findFiboElement(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        int thisElem = 0;
        int nextElem = 1;
        if (n == 1 || n == 2) {
            return n == 1 ? 0 : 1;
        }
        for (int i = 3; i <= n + 1; i ++) {
            nextElem = thisElem + nextElem;
            thisElem = nextElem - thisElem;
            System.out.println(thisElem);
        }
        return thisElem;
    }
}
