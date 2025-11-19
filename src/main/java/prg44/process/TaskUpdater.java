package prg44.process;

import prg44.Status;

import java.time.LocalDate;

class TaskUpdater {
    private final Task task;

    public TaskUpdater(Task task) {
        this.task = task;
    }

    TaskUpdater description(String newDescription) {
        if (newDescription != null) {
            this.task.setDescription(newDescription);
        }
        return this;
    }

    TaskUpdater deadLine(LocalDate newDeadline) {
        if (newDeadline != null) {
            this.task.setDeadLine(newDeadline);
        }
        return this;
    }

    TaskUpdater status(Status newStatus) {
        if (newStatus != null) {
            task.setStatus(newStatus);
        }
        return this;
    }
}
