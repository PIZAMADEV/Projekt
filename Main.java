public class Main {
    public static void main(String[] args) {
        Zadania nowe = new Zadania("TAK", "02.02.2027", "aktywny");
        String tytul = nowe.getTytul();
        String data = nowe.getData();
        String status = nowe.getStatus();
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 1; i++) {
            System.out.println(tytul+"   "+data+"   "+status);
        }
        System.out.println("--------------------------------------------");
    }
}