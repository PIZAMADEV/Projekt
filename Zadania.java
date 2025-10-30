import Zadania.Status;

public class Zadania {
    private static int nextId = 1;

    private int id;
    private String title;
    private boolean zakonczone;
    private Status status;

    public Zadania(String title, Status status) {
        this.id = nextId++;
        this.title = title;
        this.status = status;
        this.zakonczone = false;
    }

    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getZakonczone() {
        return zakonczone;
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

    public void setZakonczone(boolean zakonczone) {
        this.zakonczone = zakonczone;
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