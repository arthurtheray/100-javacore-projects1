package prg43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PECS тренировка. Копирование между списками.
 * * Требования: `List<? super T>` из `List<? extends T>`; без `Collections.copy`.
 * * Теория: принцип PECS (Producer Extends, Consumer Super).
 * План:
 * Исходные листы задаются в Main. Метод copy - void статический в том же Main классе.
 */
public class Main {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> integers = List.of(4, 8, 15, 16, 23, 42);
        System.out.println("destination List: " + numbers);
        System.out.println("Source List: " + integers);
        copy(integers, numbers);
        System.out.println(numbers);
    }

    private static <T> void copy(List<? extends T> producer, List<? super T> consumer) {
        if (consumer.size() < producer.size()) {
            throw new IndexOutOfBoundsException("Не влазит");
        }
        for (int i = 0; i < producer.size(); i++) {
            consumer.set(i, producer.get(i));
        }
        System.out.println("Copying successful!");
    }
}
