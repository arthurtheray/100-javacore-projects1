package prg44.process;

import prg44.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Для инициализации задачи должны быть заданы обязательные параметры: описание, срок выполнения и идентификатор
 */
class Task {
    private String description;
    private LocalDateTime creatingDateTime;
    private LocalDate deadLine;
    private Status status;
    private final int id;

    /**
     * Идентификатор у каждой созданной задачи должен быть уникальным. В случае если у нескольких задач будет одинаковый
     * идентификатор, неизвестно какая именно из задач будет обновлена прочитана, обновлена или удалена.
     * @param description Описание задачи
     * @param deadLine срок выполнения
     * @param id идентификатор.
     */
    Task(String description, LocalDate deadLine, int id) {
        if (!deadLine.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Deadline cannot be in past");
        }
        this.description = description;
        this.deadLine = deadLine;
        this.creatingDateTime = LocalDateTime.now();
        this.status = Status.STARTED;
        this.id = id;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    LocalDateTime getCreatingDateTime() {
        return creatingDateTime;
    }

    void setCreatingDateTime(LocalDateTime creatingDateTime) {
        this.creatingDateTime = creatingDateTime;
    }

    LocalDate getDeadLine() {
        return deadLine;
    }

    void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    Status getStatus() {
        return status;
    }

    void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", creatingDateTime=" + creatingDateTime +
                ", deadLine=" + deadLine +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Task task = (Task) object;
        return id == task.id && Objects.equals(description, task.description) && Objects.equals(creatingDateTime, task.creatingDateTime) && Objects.equals(deadLine, task.deadLine) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, creatingDateTime, deadLine, status, id);
    }
}
