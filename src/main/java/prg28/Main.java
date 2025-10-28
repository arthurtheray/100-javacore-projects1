package prg28;

import java.util.Arrays;

/**
 * Сортировка пузырьком.
 *    1. Требования: своя реализация; без `Arrays.sort`.
 *    2. Теория: базовые сортировки, сравнение и обмен, оптимизация раннего выхода.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = generateArray(10);
        System.out.println("unsorted array:\t\t" + Arrays.toString(arr));
        System.out.println("sorted array:\t\t" + Arrays.toString(sortArray(arr)));
    }

    private static int[] sortArray(int[] arr) {
        int[] sortedArr = arr;
        int buffer;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (sortedArr[i] < sortedArr[i + 1]) {
                    buffer = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = buffer;
                    isSorted = false;
                }
            }
        }
        return sortedArr;
    }

    private static int[] generateArray(int length) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = (int) ((Math.random() - Math.random()) * 10);
        }
        return res;
    }


}
