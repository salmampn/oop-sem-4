package latihan2;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan pilihan bank (1 untuk Bank A, 2 untuk Bank B, 3 untuk Bank C): ");
        int choice = scanner.nextInt();
        scanner.close();

        Bank bank;
        switch (choice) {
            case 1:
                bank = new BankA();
                break;
            case 2:
                bank = new BankB();
                break;
            case 3:
                bank = new BankC();
                break;
            default:
                System.out.println("Bank Tidak Terdaftar");
                return;
        }

        int balance = bank.getBalance();
        System.out.println("Saldo Bank: $" + balance);
    }
}
