package week02.salma.id.ac.umn;

import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan nilai terkecil: ");
        int lower = input.nextInt();

        System.out.println("Masukkan nilai terbesar: ");
        int upper = input.nextInt();

        int sum = 0;
        for (int i = lower; i <= upper; i++) {
            boolean isPrime = true;
            if (i < 2) {
                isPrime = false;
            } else {
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                sum += i;
            }
        }

        System.out.println("Jumlah dari semua nilai prima dari " + lower + " sampai " + upper + " adalah " + sum);
    }
}
