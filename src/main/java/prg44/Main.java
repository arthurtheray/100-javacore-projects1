package prg44;

import prg44.process.TaskProcessor;

import java.time.LocalDate;

/**
 * Коллекции: список задач. CRUD над `ArrayList<Task>`.
 * * Требования: итератор для удаления; без индексов в удалении.
 * * Теория: `List` API, `Iterator` и `iterator.remove`, fail-fast.
 */
public class Main {
    public static void main(String[] args) {
        TaskProcessor taskProcessor = TaskProcessor.init();
        taskProcessor.create("Построить дом", LocalDate.of(2025, 12, 31));
        taskProcessor.create("Родить сына", LocalDate.of(2026, 3, 8));
        taskProcessor.create("Убить врага", LocalDate.of(2025, 11, 30));
        taskProcessor.create("вЫРАСТИТЬ ДЕРЕВО", LocalDate.of(2025, 12, 31));
        taskProcessor.create("Покорить космос", LocalDate.of(2027, 1, 1));

        System.out.println();
        System.out.println(taskProcessor.readAll());

        taskProcessor.update(5, "Купить молока", null, null);
        taskProcessor.update(4, null, null, Status.PAUSED);
        System.out.println();
        System.out.println(taskProcessor.readAll());
    }
}
