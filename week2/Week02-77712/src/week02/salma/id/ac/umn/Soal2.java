package week02.salma.id.ac.umn;

import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        int angka;
        boolean flag = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan angka: ");
        angka = input.nextInt();

        for (int i = 2; i <= angka / 2; ++i) {
            // condition for nonprime number
            if (angka % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag && angka > 1)
            System.out.println("Angka " + angka + " adalah angka prima");
        else
            System.out.println("Angka " + angka + " adalah bukan angka prima");
    }
}
