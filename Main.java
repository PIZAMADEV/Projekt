import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

import Zadania.*;

public class Main {
    public static void main(String[] args) {
        List<Zadania> tasks = new ArrayList<>();
        List<ZadaniaTerminowe> tasks_ter = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean i = true;
        while (i){
            System.out.println(ConsoleColors.PURPLE + "[MENU]"  + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "[1]"  + ConsoleColors.RESET + " Pokaz zadania");
            System.out.println(ConsoleColors.PURPLE + "[2]"  + ConsoleColors.RESET + " Pokaz zadania terminowe");
            System.out.println(ConsoleColors.PURPLE + "[3]"  + ConsoleColors.RESET + " Wyjdz");
            System.out.println("--------------------------------------");
            System.out.println(" ");
            System.out.print("Wybrano: ");
            String numer = scan.next();
            System.out.println(" ");
            if (numer == "3"){
                break;
            }
            switch (numer){
                case "1": // ODPALENIE MENU ZADAŃ
                    i = false;
                    boolean  j = true;
                    while (j){
                        Table.printTable(tasks); // Wyświetlanie tabelki z zadaniami z Clasy Table.java
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
                            case 1 : // Dodawnie nowego zadania
                                creatNew(scan, tasks);
                                break;
                            case 2 : // Usuwanie zadania po ID
                                deleta(scan, tasks);
                                break;
                            case 3 : // Edytowanie całego zadania po ID
                                editTask(scan, tasks);
                                break;
                            case 4 : // Edytowanie statusu zadania po ID
                                editStatusTask(scan, tasks);
                                break;
                            default: // Walidacja formularza (czy ktoś nie wpisał coś co nie istnieje w menu)
                                System.out.println(ConsoleColors.RED + "NIE PODANO NUMERU DZIAŁANIA"+ConsoleColors.RESET);
                        }
                    }
                    break;
                case "2": // ODPALENIE MENU ZADAŃ TERMINOWYCH
                    i = false;
                    boolean  k = true;
                    while (k){
                        System.out.println(ConsoleColors.PURPLE + "[ZADANIA TERMINOWE]"  + ConsoleColors.RESET);
                        System.out.println("--------------------------------------");
                        TableTermin.printTableTermin(tasks_ter); // Wyświetlanie tabelki z zadaniami terminowymi z Clasy TableTermin.java
                        System.out.println("--------------------------------------");
                        System.out.println(ConsoleColors.PURPLE + "[1]"  + ConsoleColors.RESET + " Dodaj zadania");
                        System.out.println(ConsoleColors.PURPLE + "[2]"  + ConsoleColors.RESET + " Usun zadania");
                        System.out.println(ConsoleColors.PURPLE + "[3]"  + ConsoleColors.RESET + " Edytuj zadania");
                        System.out.println(ConsoleColors.PURPLE + "[4]"  + ConsoleColors.RESET + " Zmień status");
                        System.out.println(ConsoleColors.PURPLE + "[5]"  + ConsoleColors.RESET + " Wyjdz");
                        System.out.println("--------------------------------------");
                        System.out.println(" ");
                        System.out.print("Wybrano: ");
                        int numer_2 = scan.nextInt();
                        System.out.println(" ");
                        switch (numer_2){
                            case 1: // Tworzenie nowego adania terminowego
                                creatNewTermin(scan, tasks_ter);
                                break;
                            case 2: // Usunięcie zadania terminowego
                                deletaTermin(scan, tasks_ter);
                                break;
                            case 3: // Edytowanie statusu po ID zadani terminowych
                                editStatusTaskTermin(scan, tasks_ter);
                                break;
                            case 4: // Edytowanie całego zadania terminowego po ID
                                editTaskTermin(scan, tasks_ter);
                                break;
                        }
                    }
                    break;
                case "3":
                    i = false; // Wyłączenie programu
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "NIE PODANO NUMERU DZIAŁANIA"+ConsoleColors.RESET);
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

    private static void editStatusTaskTermin(Scanner scan, List<ZadaniaTerminowe> tasks_ter) {
        System.out.println("Podaj ID zadania:");
        int id_zad = scan.nextInt();
        System.out.println("Podaj Status zadania (DONE, IN_PROGRESS, TODO, OVERDUE):");
        String status_zad = scan.next();
        Zadania foundObject = null;

        for (Zadania obj : tasks_ter) {
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
        boolean ukonczenie = scan.nextBoolean();
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
        foundObject_edit.setZakonczone(ukonczenie);
        foundObject_edit.setStatus(Status.valueOf(status_zad_edit));
    }
    private static void editTaskTermin(Scanner scan, List<ZadaniaTerminowe> tasks_ter) {
        System.out.println("Podaj ID zadania:");
        int id_zad_edit = scan.nextInt();
        System.out.println("Podaj nową nazwe zadania");
        String nazwa_zad = scan.next();
        System.out.println("Podaj nową date wwykonania zadania");
        boolean ukonczenie = scan.nextBoolean();
        System.out.println("Podaj nowy status zadania (DONE, IN_PROGRESS, TODO, OVERDUE):");
        String status_zad_edit = scan.next();
        ZadaniaTerminowe foundObject_edit = null;

        for (ZadaniaTerminowe obj : tasks_ter) {
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
        foundObject_edit.setZakonczone(ukonczenie);
        foundObject_edit.setStatus(Status.valueOf(status_zad_edit));
    }

    private static void creatNew(Scanner scan, List<Zadania> tasks) {
        System.out.println("Podaj nazwe zadania:");
        String nazwa_zad_ter = scan.next();
        tasks.add(new Zadania(nazwa_zad_ter, Status.IN_PROGRESS));
    }
    private static void creatNewTermin(Scanner scan, List<ZadaniaTerminowe> tasks_ter) {
        System.out.println("Podaj nazwe zadania:");
        String nazwa_zad_ter = scan.next();
        System.out.println("Podaj date wykonania zadania:");
        String data_zad_ter = scan.next();
        tasks_ter.add(new ZadaniaTerminowe(nazwa_zad_ter, Status.IN_PROGRESS,data_zad_ter));
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
    private static void deletaTermin(Scanner scan, List<ZadaniaTerminowe> tasks_ter) {
        System.out.println("Podaj ID zadania:");
        int id_zad_del = scan.nextInt();
        ZadaniaTerminowe foundObject_del = null;

        for (ZadaniaTerminowe obj : tasks_ter) {
            if (obj.getId() == id_zad_del) {
                foundObject_del = obj;
                break;
            }else {
                System.out.println(" ");
                System.out.println("Nie można znaleźć zadania o podanym ID");
                System.out.println(" ");
            }
        }
        tasks_ter.remove(foundObject_del);
    }
}