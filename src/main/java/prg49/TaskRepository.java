package prg49;

public interface TaskRepository extends Iterable<Task> {
    void add(String taskCaption, int priority);
    String poll();
}
