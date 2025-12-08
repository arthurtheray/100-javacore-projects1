package prg49;

import java.util.Objects;

public class Task {
    private String caption;
    private int priority;
    private double seq;

    /**
     * @param caption Текстовое описание задачи
     * @param priority приоритет от 0 до 5. 0 - высший приоритет, 5 - низший приоритет
     * @param seq порядковый номер задачи
     */
    public Task(String caption, int priority, double seq) {
        if (caption.isBlank()) {
            throw new IllegalArgumentException("У задачи должно быть текстовое описание");
        }

        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("Приоритет задается значениями от 0 до 5");
        }

        this.caption = caption;
        this.priority = priority;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Task task = (Task) object;
        return priority == task.priority && Objects.equals(caption, task.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, priority);
    }

    public double getSeq() {
        return seq;
    }

    public void setSeq(double seq) {
        this.seq = seq;
    }
}
