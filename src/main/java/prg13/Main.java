package prg13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Сумма массива. Ввести массив и найти сумму/среднее.
 *    1. Требования: использовать массив `int[]`; без `ArrayList`.
 *    2. Теория: объявление и инициализация массивов, длина массива, for-each.
 */
public class Main {
    public static void main(String[] args) {
        try {
            int[] numbers = askForNumbers();
            getSumAndAverageOfNumbers(numbers);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Перезапусти программу и введи корректно");
        }
    }

    private static void getSumAndAverageOfNumbers(int[] numbers) {
        int sumOfNumbers = 0;
        for (int number:numbers) {
            sumOfNumbers +=number;
        }
        System.out.println("sum of " + Arrays.toString(numbers) + " is " + sumOfNumbers);
        System.out.println("average of " + Arrays.toString(numbers) + " is " + sumOfNumbers / numbers.length);
    }

    private static int[] askForNumbers() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите числа разделяя их пробелами: ");
        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");
        int[] userInputInts = new int[userInputArray.length];
        for (int i = 0; i <= userInputArray.length - 1; i++) {
            userInputInts[i] = Integer.parseInt(userInputArray[i]);
        }
        return userInputInts;
    }
}
