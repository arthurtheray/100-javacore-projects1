package prg15;

import java.util.Arrays;

/**
 * 15. Слияние двух отсортированных массивов.
 *    1. Требования: два указателя; без `Arrays.sort`.
 *    2. Теория: техника двух указателей, стабильность слияния.
 */
public class Main {
    public static void main(String[] args) {
        int[] firstSortedArray = {0, 1, 3, 123, 123, 1111, 2222, 1555555, 123344664};
        int[] secondSortedArray = {-15, 124, 1111, 22225, 1555355, 123344664, 1233213213, 1233213216, 1233213244, 1233213266, 1233213277, 1233213999};
        int[] collapsedArray = collapseArrays(secondSortedArray, firstSortedArray);
        System.out.println(Arrays.toString(collapsedArray));
        int[] collapsedArray2 = collapseArrays(firstSortedArray, secondSortedArray);
        System.out.println(Arrays.toString(collapsedArray2));
    }

    private static int[] collapseArrays(int[] firstSortedArray, int[] secondSortedArray) {
        int[] collapsedArray = new int[firstSortedArray.length + secondSortedArray.length];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i <= firstSortedArray.length + secondSortedArray.length; i++) {
            if (firstIndex != firstSortedArray.length && firstSortedArray[firstIndex] <= secondSortedArray[secondIndex]) {
                collapsedArray[i] = firstSortedArray[firstIndex];
                firstIndex++;
                continue;
            }
            collapsedArray[i] = secondSortedArray[secondIndex];
            secondIndex++;
            if (secondIndex == secondSortedArray.length) {
                while (i != collapsedArray.length - 1) {
                    i++;
                    collapsedArray[i] = firstSortedArray[firstIndex];
                    firstIndex++;
                }
                return collapsedArray;
            }
        }
        return collapsedArray;
    }
}
