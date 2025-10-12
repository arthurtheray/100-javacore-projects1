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
        int[] secondSortedArray = {15, 124, 1111, 22225, 1555355, 123344664, 1233213213};
        int[] collapsedArray = collapseArrays(firstSortedArray, secondSortedArray);
        System.out.println(Arrays.toString(collapsedArray));
    }

    private static int[] collapseArrays(int[] firstSortedArray, int[] secondSortedArray) {
        int[] collapsedArray = new int[firstSortedArray.length + secondSortedArray.length];
        int i = 0;
        int j = 0;
        while (i < firstSortedArray.length) {
            if (firstSortedArray[i] <= secondSortedArray[i]) {
                collapsedArray[j] = firstSortedArray[i];
                j++;
                collapsedArray[j] = secondSortedArray[i];
                j++;
            } else {
                collapsedArray[j] = secondSortedArray[i];
                j++;
                collapsedArray[j] = firstSortedArray[i];
                j++;
            }
            i++;
        }
        while (j < firstSortedArray.length + secondSortedArray.length) {
            if (firstSortedArray.length <= secondSortedArray.length) {
                collapsedArray[j] = secondSortedArray[i];
                i++;
                j++;
            } else {
                collapsedArray[j] = firstSortedArray[i];
                i++;
                j++;
            }
        }
        return collapsedArray;
    }
}
