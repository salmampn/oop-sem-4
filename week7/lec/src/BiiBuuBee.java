import java.util.Scanner;

public class BiiBuuBee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan sebuah bilangan: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            if (i % 2 == 0 && i % 3 == 0) {
                System.out.print(" Bii");
            } else if (i % 2 == 0) {
                System.out.print(" Buu");
            } else if (i % 3 == 0) {
                System.out.print(" Bee");
            }
            System.out.println();
        }
        input.close();
    }
}