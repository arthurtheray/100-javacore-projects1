package prg49;

/**
 * 49. Очередь задач по приоритету (PriorityQueue)
 * Суть: реализовать диспетчер задач: на вход операции add(task, priority) и последовательность poll();
 * на выход — порядок выполнения от высокого приоритета к низкому.
 * Ограничения: использовать PriorityQueue с собственным Comparator; не использовать Comparable у task;
 * без сторонних библиотек, без сортировки всей коллекции перед каждым poll.
 * Теория: PriorityQueue, компараторы, естественный vs заданный порядок, амортизированная сложность операций.
 */
public class Main {
    public static void main(String[] args) {
        TaskRepository tasksRepository = new PriorityQueueTasksRepository();
        TaskConsoleService taskConsoleService = new TaskConsoleService(tasksRepository);
        taskConsoleService.init();
    }
    //todo: решить проблему с выводом лишних строк и сортировкой (последнее добавленное должно быть более приоритетное)
}
