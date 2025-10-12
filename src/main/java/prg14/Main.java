package prg14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Поиск максимума в массиве. Вернуть индекс и значение.
 *    1. Требования: отдельный метод; без сортировки.
 *    2. Теория: линейный проход, хранение текущего лучшего значения/индекса.
 */
public class Main {
    public static void main(String[] args) {
        try {
            int[] intArray = askForIntArray();
            System.out.printf("Maximum is: %s", findMaximum(intArray));
        } catch (Exception e) {
            System.out.println("ошибка ввода");
        }
    }

    private static int findMaximum(int[] intArray) {
        int max = 0;
        for (int intElem:intArray) {
            max = intElem > max ? intElem : max;
        }
        return max;

    }

    private static int[] askForIntArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи массив int разделяя элементы пробелами");
        String[] userInput = scanner.nextLine().split(" ");
        return Arrays.stream(userInput).mapToInt(Integer::parseInt).toArray();
    }
}
