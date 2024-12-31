package week5.salma.id.ac.umn.Tugas;

import java.util.Scanner;

public class Tugas1 {

    public static void Circle() {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan warna: ");
        String color = in.next();

        System.out.println("-------------Lingkaran-------------");
        System.out.print("Masukkan jari-jari    : ");
        double radius = in.nextDouble();
        Circle circle = new Circle(radius, color);
        System.out.println("Warna                 : " + circle.getColor());
        System.out.println("Jari-jari             : " + circle.getRadius());
        System.out.println("Keliling Lingkaran    : " + circle.getPerimeter());
        System.out.println("Luas Lingkaran        : " + circle.getArea());
    }

    public static void Square() {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan warna: ");
        String color = in.next();

        System.out.println("-------------Persegi-------------");
        System.out.print("Masukkan sisi    : ");
        double side = in.nextDouble();
        Square square = new Square(side, color);
        System.out.println("Warna            : " + square.getColor());
        System.out.println("Sisi             : " + square.getSide());
        System.out.println("Keliling Persegi : " + square.getPerimeter());
        System.out.println("Luas Persegi     : " + square.getArea());
    }

    public static void Rectangle() {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan warna: ");
        String color = in.next();

        System.out.println("-------------Persegi Panjang-------------");
        System.out.print("Masukkan panjang    : ");
        double length = in.nextDouble();
        System.out.print("Masukkan lebar      : ");
        double width = in.nextDouble();
        Rectangle rectangle = new Rectangle(width, length, color);
        System.out.println("Warna                      : " + rectangle.getColor());
        System.out.println("Panjang                    : " + rectangle.getLength());
        System.out.println("Lebar                      : " + rectangle.getWidth());
        System.out.println("Keliling Persegi Panjang   : " + rectangle.getPerimeter());
        System.out.println("Luas Persegi Panjang       : " + rectangle.getArea());
    }

    public static void Triangle() {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan warna: ");
        String color = in.next();

        System.out.println("-------------Segitiga Siku-Siku-------------");
        System.out.print("Masukkan alas    : ");
        double base = in.nextDouble();
        System.out.print("Masukkan tinggi  : ");
        double height = in.nextDouble();

        Triangle triangle = new Triangle(base, height, color);
        System.out.println("Warna             : " + triangle.getColor());
        System.out.println("Alas              : " + triangle.getBase());
        System.out.println("Tinggi            : " + triangle.getHeight());
        System.out.println("Keliling Segitiga : " + triangle.getPerimeter());
        System.out.println("Luas Segitiga     : " + triangle.getArea());
    }

    public static void main(String[] args) {
        int menu;
        Scanner in = new Scanner(System.in);

        for (;;) {
            System.out.println("-------Program Menghitung Bangun Ruang-------");
            System.out.println("1. Lingkaran");
            System.out.println("2. Persegi");
            System.out.println("3. Persegi Panjang");
            System.out.println("4. Segitiga");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            menu = in.nextInt();
            switch (menu) {
                case 1:
                    Circle();
                    break;
                case 2:
                    Square();
                    break;
                case 3:
                    Rectangle();
                    break;
                case 4:
                    Triangle();
                    break;
                case 5:
                    System.out.println("Keluar Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}
