import java.util.*;
import java.time.*;

public class Zadania {
    private String tytul;
    private String data;
    private String status;

    public Zadania(String tytul, String data,String status){
        this.tytul = tytul;
        this.data = data;
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getTytul() {
        return tytul;
    }
}