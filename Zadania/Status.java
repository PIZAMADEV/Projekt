package Zadania;

public enum Status {
    TODO,
    IN_PROGRESS,
    DONE,
    OVERDUE;

    public boolean isCompleted() {
        return this == DONE;
    }
    public boolean isInProgres() {
        return this == IN_PROGRESS;
    }
    public boolean isOverdue() {
        return this == OVERDUE;
    }
    public boolean isTODO() {
        return this == TODO;
    }
}
