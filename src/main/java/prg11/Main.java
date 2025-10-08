package prg11;

/**
 * Реверс числа. Перевернуть цифры.
 *    1. Требования: арифметика; без строк.
 *    2. Теория: модуль числа, работа с разрядами, отрицательные значения.
 */
public class Main {
    public static void main(String[] args) {
        int number = -123;
        int reversedNumber = reverseNumber(number);
        System.out.printf("%s задом наперёд: %s", number, reversedNumber);
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;
        for (int i = getNumberDigitsCount(number) - 1; i >= 0; i--) {
            reversedNumber = (int) ((number % 10) * Math.pow(10, (double) i)) + reversedNumber;
            number = number / 10;
        }
        return Math.abs(reversedNumber);
    }

    private static int getNumberDigitsCount(int number) {
        int numberDigitsCount = 0;
        while (number != 0) {
            number = number / 10;
            numberDigitsCount++;
        }
        return numberDigitsCount;
    }
}
