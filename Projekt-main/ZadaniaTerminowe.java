import Zadania.Status;

public class ZadaniaTerminowe extends Zadania{
    private String deadline;
    private Status status;
    private static int nextId = 1;
    private int id;

    public ZadaniaTerminowe(String title, Status status, String deadline) {
        super(title, status);
        this.id = nextId++;
        this.deadline = deadline;
    }

    public int getId(){return id;}

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