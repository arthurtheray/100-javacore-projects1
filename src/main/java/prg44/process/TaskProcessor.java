package prg44.process;

import prg44.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * CRUD над ArrayList<Task>.
 * Позволяет добавлять, читать, обновлять и удалять задачи.
 */
public class TaskProcessor {
    private static TaskProcessor instance;
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int id = 1;

    public static TaskProcessor init() {
        if (instance == null) {
            instance = new TaskProcessor();
        }
        return instance;
    }

    public void create(String description, LocalDate deadLine) {
        tasks.add(new Task(description, deadLine, nextId()));
    }

    private int nextId() {
        return id++;
    }

    public String read(int id) {
        Task found = findTask(id);
        if (found == null) {
            throw new NullPointerException("ID not found");
        }
        return found.toString();
    }

    public String readAll() {
        return tasks.toString().replace("},", "},\n"); //todo:реализовать нормальное форматирование
    }

    public void delete(int id) {
        if (tasks.isEmpty()) {
            throw new IllegalStateException("Tasks base is empty");
        }
        tasks.removeIf(task -> task.getId() == id);
    }

    /**
     * Изменить задачу
     * @param id - ID задачи. Обязательное поле
     * @param newDescription - Новое описание задачи. Null - если не требуется изменений
     * @param newDeadline - новый срок выполнения. Null - если не требуется изменений
     * @param newStatus - новый статус. Null - если не требуется изменений
     */
    public void update(int id, String newDescription, LocalDate newDeadline, Status newStatus) {
        changeTask(id, newDescription, newDeadline, newStatus);
    }

    private void changeTask(int id, String newDescription, LocalDate newDeadline, Status newStatus) {
        Task t = findTask(id);
        if (t == null) {
            throw new IllegalStateException("Task not found");
        }
        TaskUpdater taskBuilder = new TaskUpdater(t);
        taskBuilder
                .status(newStatus)
                .deadLine(newDeadline)
                .description(newDescription);
    }

    private Task findTask(int id) {
        Task foundTask = null;
        if (id <= tasks.size() / 2) {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    foundTask = task;
                    break;
                }
            }
        } else {
            ListIterator<Task> it = tasks.listIterator(tasks.size());
            while (it.hasPrevious()) {
                Task previous = it.previous();
                if (previous.getId() == id) {
                    foundTask = previous;
                    break;
                }
            }
        }
        return foundTask;
    }
}
