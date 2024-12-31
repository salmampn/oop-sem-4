package week03.salma.id.ac.umn;

import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();
        System.out.println("--------------------------------");

        System.out.println("String Anda:  " + nama);
        System.out.println(String.format("%-22s %-22s", "1. charAt", "2. length"));
        System.out.println(String.format("%-22s %-22s", "3. substring(n)", "4. substring(m, n)"));
        System.out.println(String.format("%-22s %-22s", "5. contains", "6. concat"));
        System.out.println(String.format("%-22s %-22s", "7. replace", "8. split"));
        System.out.println(String.format("%-22s %-22s", "9. lowerCase", "10. upperCase"));
        System.out.print("Pilih Menu: ");

        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                System.out.println("-----charAt-----");
                System.out.println("Nama: " + nama);
                System.out.print("Input: ");
                int index = scanner.nextInt();
                System.out.println("Hasil: " + nama.charAt(index));
                break;

            case 2:
                System.out.println("-----length-----");
                System.out.println("Nama: " + nama);
                System.out.println("Input: " + nama.length());
                break;

            case 3:
                System.out.println("-----substring(n)-----");
                System.out.println("Nama: " + nama);
                System.out.print("Input: ");
                int beginIndex = scanner.nextInt();
                System.out.println("Hasil: " + nama.substring(beginIndex));
                break;

            case 4:
                System.out.println("-----substring(m, n)-----");
                System.out.println("Nama: " + nama);
                System.out.print("Input Mulai: ");
                int startIndex = scanner.nextInt();
                System.out.print("Input Akhir: ");
                int endIndex = scanner.nextInt();
                System.out.println("Hasil: " + nama.substring(startIndex, endIndex));
                break;

            case 5:
                System.out.println("-----contains-----");
                System.out.println("Nama: " + nama);
                scanner.nextLine();
                System.out.print("Input: ");
                String searchString = scanner.nextLine();
                System.out.println("Hasil: " + nama.contains(searchString));
                break;

            case 6:
                System.out.println("-----concat-----");
                System.out.println("Nama: " + nama);
                scanner.nextLine();
                System.out.print("Input: ");
                String concatString = scanner.nextLine();
                System.out.println("Hasil: " + nama.concat(concatString));
                break;

            case 7:
                System.out.println("-----replace-----");
                System.out.println("Nama: " + nama);
                System.out.print("Input kata yang diganti: ");
                scanner.nextLine();
                String oldWord = scanner.nextLine();
                System.out.print("Input kata pengganti: ");
                String newWord = scanner.nextLine();
                System.out.println("Hasil: " + nama.replace(oldWord, newWord));
                break;

            case 8:
                System.out.println("-----split-----");
                System.out.println("Nama: " + nama);
                System.out.print("Input: ");
                scanner.nextLine();
                String delimiter = scanner.nextLine();
                String[] parts = nama.split(delimiter);
                for (String part : parts) {
                    System.out.println("Hasil: " + part);
                }
                break;

            case 9:
                System.out.println("-----lowerCase-----");
                System.out.println("Nama: " + nama);
                System.out.println("Hasil: " + nama.toLowerCase());
                break;

            case 10:
                System.out.println("-----upperCase-----");
                System.out.println("Nama: " + nama);
                System.out.println("Hasil: " + nama.toUpperCase());
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}
