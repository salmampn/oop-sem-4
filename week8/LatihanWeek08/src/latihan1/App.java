package latihan1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan pilihan (1/2): ");
        int input = scanner.nextInt();
        scanner.close();

        Parent obj;
        if (input == 1) {
            obj = new Child1();
        } else if (input == 2) {
            obj = new Child2();
        } else {
            System.out.println("Input tidak valid");
            return;
        }
        obj.message();
    }
}
