package prg6;

/**
 * Сумма цифр. Подсчитать сумму цифр натурального числа.
 *     1. Требования: цикл `while`; без строк/массивов.
 *     2. Теория: циклы `while/do-while`, целочисленное деление `/` и `%`, инварианты цикла.
 */
public class Main {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100000);
        System.out.println(number);
        printDigitsCountAndSumOfDigits(number);

    }

    public static void printDigitsCountAndSumOfDigits(int number) {
        long n = Math.abs(number);
        long sumOfDigits = 0;
        if (number == 0) {
            System.out.println(0);
        } else {
            do {
                sumOfDigits = sumOfDigits + n % 10;
                n /= 10;
            } while (n > 0);
        }
        System.out.println(sumOfDigits);
    }
}
