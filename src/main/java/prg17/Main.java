package prg17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Поворот массива на k вправо.
 *    1. Требования: реверсы подмассивов; без дополнительного массива.
 *    2. Теория: реверс массива, циклические сдвиги, модульная арифметика.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        moveArr(arr, askForK());
        System.out.println(Arrays.toString(arr));
    }

    private static void moveArr(int[] arr, int k) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (k == 0) {
            return;
        }
        int normalizedK = k % arr.length;
        reverseArr(arr, 0, arr.length - 1);
        reverseArr(arr, 0, normalizedK - 1);
        reverseArr(arr, normalizedK, arr.length - 1);
    }

    public static int askForK() {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите коэффициент сдвига k");
            try {
                userInput = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("ошибка ввода");
                scanner.next();
            }
        }
        return userInput;
    }

    public static void reverseArr(int[] arr, int start, int end) {
        if (arr.length == 1 || start == end) {
            return;
        }
        if (start > end) {
            throw new IllegalArgumentException("Индекс начала разворачиваемого массива должен быть меньше индекса конца");
        }

        int buffer;
        while (start < end) {
            buffer = arr[start];
            arr[start] = arr[end];
            arr[end] = buffer;
            start++;
            end--;
        }
    }
}
