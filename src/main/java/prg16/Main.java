package prg16;

import java.util.Arrays;

/**
 * Удаление дубликатов в массиве. Сдвиг и заполнение нулями.
 *    1. Требования: однопроходный алгоритм; без коллекций.
 *    2. Теория: инварианты, два указателя (slow/fast), изменение на месте (in-place).
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 0, 1, 2, 3, 3, 3, 123, 125, 111223, 2321111, 2321111, 1522333333};
        System.out.println(Arrays.toString(arr));
        System.out.println("без дубликатов: " + Arrays.toString(removeDuplicates(arr)));
    }

    /**
     * @param arr отсортированный массив
     * @return отсортированный массив без дубликатов
     */
    private static int[] removeDuplicates(int[] arr) {
        int index = 0;
        int resIndex = 0;
        int buffer = 0;
        int[] result = new int[arr.length];

        while (index != arr.length) {
            if (arr[index] == buffer) {
                buffer = arr[index];
                index++;
            } else {
                result[resIndex] = arr[index];
                resIndex++;
                buffer = arr[index];
                index++;
            }
        }
        return result;
    }
}
