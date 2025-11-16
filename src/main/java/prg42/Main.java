package prg42;

import java.util.*;

/**
 * Обобщённый метод `maxOf`.** По `Comparator`.
 *    1. Требования: `<T>` с `Comparator<? super T>`; без стримов.
 *    2. Теория: верхние/нижние ограничения (`extends/super`), wildcard-и.
 */
public class Main {
    public static void main(String[] args) {
        Cat tomCat = new Cat("Tom", 5.1);
        Cat shkuraCat = new Cat("Shkura", 2.6);
        Cat trishaCat = new Cat("Trisha", 7);
        System.out.println(maxOf(List.of(tomCat, shkuraCat, trishaCat),
                (first, second) -> (int) (10 * (first.getWeight() - second.getWeight()))));
    }

    private static <T> T maxOf(Collection<? extends T> catsCollection, Comparator<? super T> tCatComparator) {

        Iterator<? extends T> iterator = catsCollection.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            T next = iterator.next();
             if (tCatComparator.compare(next, max) > 0) {
                max = next;
            }
        }

        return max;
    }
}
