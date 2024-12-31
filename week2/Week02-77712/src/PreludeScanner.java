import java.util.Scanner;

public class PreludeScanner {
    public static void main(String[] args) {
        int umur;
        String nama;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nama: ");
        nama = scanner.next();

        System.out.println("Umur: ");
        umur = scanner.nextInt();

        System.out.println("--------------------------------");
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }
}
