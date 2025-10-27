package prg26;

import java.util.Scanner;

/**
 * Метод-утилита `clamp`. Ограничить значение в [min,max].
 *    1. Требования: статический метод; без библиотек.
 *    2. Теория: статические утилиты, предусловия/постусловия.
 */
public class Main {
    public static void main(String[] args) {
        int number = askForNumber();
        System.out.println(number + " clamped to [3; 22] is: " + Utils.clamp(number, 3, 22));
    }

    private static int askForNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        return scanner.nextInt();
    }
}
