package week5.salma.id.ac.umn.Tutorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Masukkan jari-jari lingkaran: ");
        double radius = s.nextDouble();
        System.out.println("Masukkan warna: ");
        String color = s.next();

        Circle circle = new Circle(radius, color);
        System.out.println("-------------Lingkaran-------------");
        System.out.println("Warna: " + circle.getColor());
        System.out.println("Jari-jari: " + circle.getRadius());
        System.out.println("Keliling Lingkaran: " + circle.getPerimeter());
        System.out.println("Luas Lingkaran: " + circle.getArea());
    }
}
