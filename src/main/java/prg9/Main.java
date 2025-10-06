package prg9;

/**
 * Факториал итеративно. Вычислить `n!`.
 *     1. Требования: `long`; без рекурсии.
 *     2. Теория: переполнение, диапазоны примитивов, итеративные алгоритмы.
 */
public class Main {
    public static final int N_MAX = 20;
    public static void main(String[] args) {
        findFactorials(N_MAX);
    }

    private static void findFactorials(int n) {
        int intRes = 1;
        long longRes = 1;
        for (int i = 1; i <= n; i++) {
            intRes *= i;
            longRes *= i;
            System.out.printf("""
                    Результат с интом:
                    %d!\t=\t%d\s
                    """, i, intRes);

            System.out.printf("""
                    Результат с лоногом
                    %d!\t=\t%d\s
                    """, i, longRes);
        }
    }
}
