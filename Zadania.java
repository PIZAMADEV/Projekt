import Zadania.Status;

public class Zadania {
    private static int nextId = 1;

    private int id;
    private String title;
    private String deadline;
    private Status status;

    public Zadania(String title, String deadline, Status status) {
        this.id = nextId++;
        this.title = title;
        this.deadline = deadline;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return status.isCompleted();
    }
    public boolean isInProgres() {
        return status.isInProgres();
    }
    public boolean isOverdue() {
        return status.isOverdue();
    }
    public boolean isTODO() {
        return status.isTODO();
    }
}