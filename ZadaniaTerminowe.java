import Zadania.Status;

public class ZadaniaTerminowe extends Zadania{
    private String deadline;
    private Status status;

    public ZadaniaTerminowe(String title, Status status, String deadline) {
        super(title, status);
        this.deadline = deadline;
    }

    public String getDeadline(){
        return deadline;
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