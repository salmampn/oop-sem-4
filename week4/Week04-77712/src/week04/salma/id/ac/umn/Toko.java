package week04.salma.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Toko {
    private static ArrayList<Barang> barangs = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void seedData() {
        barangs.add(new Barang(1, 120, 2000, "Pulpen Easy Gel 0.5mm"));
        barangs.add(new Barang(2, 30, 5000, "Penggaris 30cm"));
        barangs.add(new Barang(3, 30, 7000, "Tipe-x Roller"));
        barangs.add(new Barang(4, 50, 5000, "Pensil Mekanik"));
        barangs.add(new Barang(5, 100, 6000, "Buku Tulis"));
    }

    public static void mainMenu() {
        System.out.println("----------Menu Toko Multiguna----------");
        System.out.println("1. Pesan Barang");
        System.out.println("2. Lihat Pesanan");
        System.out.println("Ketik 0 untuk keluar");
        System.out.print("Pilihan: ");
    }

    public static void showBarang() {
        System.out.println("Daftar Barang Toko Multiguna");
        for (Barang barang : barangs) {
            System.out.println("ID      : " + barang.getId());
            System.out.println("Nama    : " + barang.getNama());
            System.err.println("Stock   : " + barang.getStock());
            System.out.println("Harga   : " + barang.getHarga());
            System.out.println("---------------------------------------");
        }
    }

    public static void pesanBarang() {
        int id, jumlah, total;
        Barang barang;

        Scanner scanner = new Scanner(System.in);

        for (;;) {
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Pesan Barang (ID) : ");
            id = scanner.nextInt();

            if (id <= 0 || id > 5) {
                System.out.println("ID tidak valid. Kembali ke menu utama");
                break;
            } else {
                System.out.print("Masukkan Jumlah : ");
                jumlah = scanner.nextInt();
                barang = barangs.get(id - 1);
                System.out.println("---------------------------------------------");
                if (jumlah > barang.getStock()) {
                    System.out.println("Stock tidak mencukupi");
                } else {
                    total = jumlah * barangs.get(id - 1).getHarga();
                    System.out.println(jumlah + " @ " + barang.getNama() + " dengan total harga " + total);
                    System.out.print("Masukkan Jumlah uang: ");
                    int uang = scanner.nextInt();
                    if (uang >= total) {
                        System.out.println("Berhasil dipesan!");
                        System.out.println("Kembalian: " + (uang - total));
                        System.out.println("---------------------------------------------");
                        // barangs.get(id - 1).minusStock(jumlah);
                        barang.minusStock(jumlah);
                        orders.add(new Order(id, jumlah, barang, total));
                    } else {
                        System.out.println("Jumlah uang tidak mencukupi");
                        System.out.println("---------------------------------------------");
                    }
                }
            }
        }
    }

    public static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("Pesanan Kosong");
        } else {
            System.out.println("-----------------------------------");
            for (Order order : orders) {
                System.out.println("ID     : " + order.getId());
                System.out.println("Nama   : " + order.getBarang().getNama());
                System.out.println("Jumlah : " + order.getJumlah());
                System.out.println("Total  : " + order.getTotal());
                System.out.println("-----------------------------------");
            }
            System.out.println("Total Belanja: " + Order.totalBelanja);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        seedData();

        for (;;) {
            mainMenu();
            menu = scanner.nextInt();
            if (menu == 0) {
                System.out.println("Terima kasih telah berbelanja di Toko Multiguna");
                break;
            }
            switch (menu) {
                case 1:
                    showBarang();
                    pesanBarang();
                    break;
                case 2:
                    showOrders();
                    break;
                default:
                    break;
            }
        }

    }
}
