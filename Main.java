import java.util.*;
import java.io.*;
import Zadania.*;

public class Main {
    public static void main(String[] args) {
        List<Zadania> tasks = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean i = true;
        while (i){
            System.out.println(ConsoleColors.PURPLE + "[MENU]"  + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "[1]"  + ConsoleColors.RESET + " Pokaz zadania");
            System.out.println(ConsoleColors.PURPLE + "[2]"  + ConsoleColors.RESET + " Pokaz raport");
            System.out.println(ConsoleColors.PURPLE + "[3]"  + ConsoleColors.RESET + " Wyjdz");
            System.out.println("--------------------------------------");
            System.out.println(" ");
            System.out.print("Wybrano: ");
            int numer = scan.nextInt();
            System.out.println(" ");
            if (numer == 3){
                break;
            }
            switch (numer){
                case 1:
                    i = false;
                    boolean  j = true;
                    while (j){
                        Table.printTable(tasks);
                        System.out.println("--------------------------------------");
                        System.out.println(ConsoleColors.PURPLE + "[MENU ZADAŃ]"  + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.PURPLE + "[1]"  + ConsoleColors.RESET + " Dodaj zadania");
                        System.out.println(ConsoleColors.PURPLE + "[2]"  + ConsoleColors.RESET + " Usun zadania");
                        System.out.println(ConsoleColors.PURPLE + "[3]"  + ConsoleColors.RESET + " Edytuj zadania");
                        System.out.println(ConsoleColors.PURPLE + "[4]"  + ConsoleColors.RESET + " Zmień status");
                        System.out.println(ConsoleColors.PURPLE + "[5]"  + ConsoleColors.RESET + " Wyjdz");
                        System.out.println("--------------------------------------");
                        System.out.println(" ");
                        System.out.print("Wybrano: ");
                        int numer_1 = scan.nextInt();
                        System.out.println(" ");
                        if (numer_1 == 5){
                            i = true;
                            break;
                        }
                        switch (numer_1){
                            case 1 :
                                creatNew(scan, tasks);
                                break;
                            case 2 :
                                deleta(scan, tasks);
                                break;
                            case 3 :
                                editTask(scan, tasks);
                                break;
                            case 4 :
                                editStatusTask(scan, tasks);
                                break;
                        }
                    }
                    break;
                case 2:
                    i = false;
                    boolean  k = true;
                    while (k){
                        System.out.println(ConsoleColors.PURPLE + "[RAPORTY]"  + ConsoleColors.RESET);
                        System.out.println("--------------------------------------");
                        Table.printTable(tasks);
                        System.out.println("--------------------------------------");
                        System.out.println(ConsoleColors.PURPLE + "[1]"  + ConsoleColors.RESET + " Wyjdz");
                        System.out.println("--------------------------------------");
                        System.out.println(" ");
                        System.out.print("Wybrano: ");
                        int numer_2 = scan.nextInt();
                        System.out.println(" ");
                        if (numer_2 == 1){
                            i = true;
                            break;
                        }
                    }
                    break;
                case 3:
                    i = false;
                    //miejsce edytowania statusów
                    break;
                default:
                    System.out.println("Nie ma akcji o tym numerze");
                    System.out.println(" ");
                    break;
            }
        }
        scan.close();
    }

    private static void editStatusTask(Scanner scan, List<Zadania> tasks) {
        System.out.println("Podaj ID zadania:");
        int id_zad = scan.nextInt();
        System.out.println("Podaj Status zadania (DONE, IN_PROGRESS, TODO, OVERDUE):");
        String status_zad = scan.next();
        Zadania foundObject = null;

        for (Zadania obj : tasks) {
            if (obj.getId() == id_zad) {
                foundObject = obj;
                break;
            }else {
                System.out.println(" ");
                System.out.println("Nie można znaleźć zadania o podanym ID");
                System.out.println(" ");
            }
        }
        foundObject.setStatus(Status.valueOf(status_zad));
    }

    private static void editTask(Scanner scan, List<Zadania> tasks) {
        System.out.println("Podaj ID zadania:");
        int id_zad_edit = scan.nextInt();
        System.out.println("Podaj nową nazwe zadania");
        String nazwa_zad = scan.next();
        System.out.println("Podaj nową date wwykonania zadania");
        String data_zad = scan.next();
        System.out.println("Podaj nowy status zadania (DONE, IN_PROGRESS, TODO, OVERDUE):");
        String status_zad_edit = scan.next();
        Zadania foundObject_edit = null;

        for (Zadania obj : tasks) {
            if (obj.getId() == id_zad_edit) {
                foundObject_edit = obj;
                break;
            }else {
                System.out.println(" ");
                System.out.println("Nie można znaleźć zadania o podanym ID");
                System.out.println(" ");
            }
        }
        foundObject_edit.setTitle(nazwa_zad);
        foundObject_edit.setDeadline(data_zad);
        foundObject_edit.setStatus(Status.valueOf(status_zad_edit));
    }

    private static void creatNew(Scanner scan, List<Zadania> tasks) {
        System.out.println("Podaj nazwe zadania:");
        String nazw_zad = scan.next();
        System.out.println("Podaj date wykonania zadania (dd-mm-rrrr):");
        String data = scan.next();
        tasks.add(new Zadania(nazw_zad, data, Status.IN_PROGRESS));
    }

    private static void deleta(Scanner scan, List<Zadania> tasks) {
        System.out.println("Podaj ID zadania:");
        int id_zad_del = scan.nextInt();
        Zadania foundObject_del = null;

        for (Zadania obj : tasks) {
            if (obj.getId() == id_zad_del) {
                foundObject_del = obj;
                break;
            }else {
                System.out.println(" ");
                System.out.println("Nie można znaleźć zadania o podanym ID");
                System.out.println(" ");
            }
        }
        tasks.remove(foundObject_del);
    }
}