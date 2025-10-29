package prg29;

import java.util.Arrays;

/**
 * **Бинарный поиск.
 *    1. Требования: вернуть индекс или `-1`; без рекурсии.
 *    2. Теория: инварианты левой/правой границы, переполнение при `(l+r)/2`.
 */
public class Main {
    public static void main(String[] args) {
        int[] sortedArr = {0, 1, 2, 3, 4, 5, Integer.MAX_VALUE / 2, Integer.MAX_VALUE - 3, Integer.MAX_VALUE};
        int targetInt = Integer.MAX_VALUE - 3;
        System.out.println("sorted array: " + Arrays.toString(sortedArr));
        System.out.println("target int: " + targetInt);
        System.out.println("index of target: " + binarySearch(targetInt, sortedArr));

    }

    private static int binarySearch(int targetInt, int[] sortedArr) {
        int res = -1;
        int right = sortedArr.length - 1;
        int left = 0;
        int i = sortedArr.length / 2;
        while (left <= right) {
            i = (right + left) / 2;
            if (sortedArr[i] == targetInt) {
                res = i;
                break;
            }
            if (sortedArr[i] > targetInt) {
                right = i;
            } else {
                left = i;
            }
        }
        return res;
    }
}
