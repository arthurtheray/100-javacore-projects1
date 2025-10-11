package prg12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Простое ли число. Проверить простоту.
 *    1. Требования: перебор до √n; без коллекций.
 *    2. Теория: сложность алгоритмов O(√n), `Math.sqrt`, ранний выход из цикла.
 */
public class Main {
    public static void main(String[] args) {
        int number = 131;
        int primeNumbersCount = 20;
        System.out.println(number + (isPrime(number) ? " простое" : " составное"));
        findPrimeNumbers(primeNumbersCount);
    }

    private static void findPrimeNumbers(int primeNumbersCount) {
        int foundPrimeNumbers = 0;
        List<Integer> foundedPrimeNumbers = new ArrayList<>();
        for (int i = 2; foundPrimeNumbers != primeNumbersCount; i++) {
            if (isPrime(i)) {
                foundedPrimeNumbers.add(i);
                foundPrimeNumbers++;
            }
        }

        Iterator<Integer> iterator = foundedPrimeNumbers.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            System.out.printf("%s", index % 10 != 0 ? iterator.next() + " " : iterator.next() + "\n");
            index++;
        }
    }

    private static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
