package prg17;

import java.util.Scanner;

/**
 * Поворот массива на k вправо.
 *    1. Требования: реверсы подмассивов; без дополнительного массива.
 *    2. Теория: реверс массива, циклические сдвиги, модульная арифметика.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {-1, 23, 33, 1, 0, 12312323, 23, 3232, Integer.MAX_VALUE};
//        moveArr(arr, askForK());
        System.out.println(4%2);
    }

    private static int[] moveArr(int[] arr, int k) {

        int newK = arr.length % k - 1;
        int buffer;
        for (int i = 0; i < arr.length; i++) {
            buffer = arr[i];
            arr[i] = arr[i + k];

        }
        return arr;
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
}
