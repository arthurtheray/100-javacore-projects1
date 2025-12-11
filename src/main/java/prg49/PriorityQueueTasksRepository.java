package prg49;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.PriorityQueue;

public class PriorityQueueTasksRepository implements TaskRepository {
    private double seq = 0;
    private final PriorityQueue<Task> priorityQueue = new PriorityQueue<>(
            Comparator
                    .comparing(Task::getPriority)
                    .thenComparing(Task::getSeq, Comparator.reverseOrder())
    );

    public void add(String task, int priority) {
        priorityQueue.offer(new Task(task, priority, seq++));
    }

    /**
     * @return текст наиболее приоритетной задачи из списка. При равных приоритетах возвращается текст последней
     * добавленной задачи. Если задач нет, возвращается null
     */
    public String peek() {
        return Optional.ofNullable(priorityQueue.peek()).map(Task::getCaption).orElse(null);
    }

    @Override
    public Iterator<Task> iterator() {
        return priorityQueue.iterator();
    }
}
