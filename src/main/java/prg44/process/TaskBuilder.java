package prg44.process;

import prg44.Status;

import java.time.LocalDate;

class TaskBuilder {
    private final Task task;

    public TaskBuilder(Task task) {
        this.task = task;
    }

    TaskBuilder description(String newDescription) {
        if (newDescription != null) {
            this.task.setDescription(newDescription);
        }
        return this;
    }

    TaskBuilder deadLine(LocalDate newDeadline) {
        if (newDeadline != null) {
            this.task.setDeadLine(newDeadline);
        }
        return this;
    }

    TaskBuilder status(Status newStatus) {
        if (newStatus != null) {
            task.setStatus(newStatus);
        }
        return this;
    }
}
