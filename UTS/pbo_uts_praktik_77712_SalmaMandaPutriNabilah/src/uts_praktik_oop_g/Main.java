package uts_praktik_oop_g;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Artikel> listArtikel = new ArrayList<>();
    private static ArrayList<Buku> listBuku = new ArrayList<>();
    private static ArrayList<Order> listOrder = new ArrayList<>();
    private static int orderId = 0;

    public static void seedData() {
        listBuku.add(new Buku("Java Programming", "John Doe", 2020, "Programming", "TechBooks", 400));
        listBuku.add(new Buku("Machine Learning in Education", "Jane Smith", 2021, "Education", "EduPublish", 350));
        listArtikel.add(
                new Artikel("Research Paper A", "Alice Johnson", 2022, "Artificial Intelligence", "Ceria University", 8,
                        3));
        listArtikel.add(new Artikel("Impact of Big Data Analytics in Healthcare", "Bob White", 2023,
                "Artificial Intelligence", "HealthTech Institute", 12, 5));
    }

    public static void showBuku() {
        for (Buku listBuku : listBuku) {
            System.out.println("Judul           : " + listBuku.getJudul());
            System.out.println("Penulis         : " + listBuku.getPenulis());
            System.err.println("Tahun Terbit    : " + listBuku.getTahunTerbit());
            System.out.println("Kategori        : " + listBuku.getKategori());
            System.out.println("Penerbit        : " + listBuku.getPenerbit());
            System.out.println("Jumlah Halaman  : " + listBuku.getJumlahHalaman());
            System.out.println("\n");
        }
    }

    public static void showArtikel() {
        for (Artikel listArtikel : listArtikel) {
            System.out.println("Judul           : " + listArtikel.getJudul());
            System.out.println("Penulis         : " + listArtikel.getPenulis());
            System.err.println("Tahun Terbit    : " + listArtikel.getTahunTerbit());
            System.out.println("Kategori        : " + listArtikel.getKategori());
            System.out.println("Universitas     : " + listArtikel.getUniversitas());
            System.out.println("Halaman         : " + listArtikel.getHalaman());
            System.out.println("Volumet         : " + listArtikel.getVolume());
            System.out.println("\n");
        }
    }

    public static void tambahBuku() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("                       Tambah Buku                          ");
        System.out.println("============================================================");
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Penerbit: ");
        String penerbit = scanner.nextLine();
        System.out.print("Jumlah Halaman: ");
        int jumlahHalaman = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Buku buku = new Buku(judul, penulis, tahunTerbit, kategori, penerbit, jumlahHalaman);
        listBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.\n");
    }

    public static void tambahArtikel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("                       Tambah Artikel                       ");
        System.out.println("============================================================");
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Universitas: ");
        String universitas = scanner.nextLine();
        System.out.print("Halaman: ");
        int halaman = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Volume: ");
        int volume = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Artikel artikel = new Artikel(judul, penulis, tahunTerbit, kategori, universitas, halaman, volume);
        listArtikel.add(artikel);
        System.out.println("Artikel berhasil ditambahkan.\n");
    }

    public static void tambahPublikasi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("                      Tambah Publikasi                      ");
        System.out.println("============================================================");
        System.out.print("Pilih Jenis Publikasi (1. Buku, 2. Artikel): ");
        int pilihan = scanner.nextInt();
        if (pilihan != 1 || pilihan != 2) {
            System.out.println("Input yang dimasukkan salah!\n");
        }
        switch (pilihan) {
            case 1:
                tambahBuku();
                break;
            case 2:
                tambahArtikel();
                break;
            default:
                break;
        }
    }

    public static void orderBuku() {
        Scanner scanner = new Scanner(System.in);
        String tanggalMulai = "20240322";
        System.out.println("============================================================");
        System.out.println("                         Order Buku                         ");
        System.out.println("============================================================");
        showBuku();
        System.out.print("Masukkan nomor buku yang ingin Anda pinjam (masukkan 0 untuk membatalkan): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        if (pilihan == 0) {
            System.out.println("Order buku batal!");
            return; // exit the method if the order is cancelled
        }
        System.out.print("Masukkan nama peminjam: ");
        String namaPeminjam = scanner.nextLine();

        System.out.print("Masukkan tanggal selesai peminjaman (format: YYYYMMDD): ");
        String tanggalSelesai = scanner.nextLine();
        String status = "Ordered"; // assuming the status is "Ordered" when a book is ordered

        orderId++;
        String orderIdString = "OID" + orderId;

        if (pilihan > 0 && pilihan <= listBuku.size()) {
            Buku buku = listBuku.get(pilihan - 1);

            Order order = new Order(buku, namaPeminjam, tanggalMulai, tanggalSelesai, status);
            listOrder.add(order);
            System.out.println("Order buku berhasil.\n");
        } else {
            System.out.println("Nomor buku yang dimasukkan tidak valid!\n");
        }
    }

    public static void orderArtikel() {
        Scanner scanner = new Scanner(System.in);
        String tanggalMulai = "20240322";
        System.out.println("============================================================");
        System.out.println("                      Order Artikel                         ");
        System.out.println("============================================================");
        showArtikel();
        System.out.print("Masukkan nomor artikel yang ingin Anda pesan (masukkan 0 untuk membatalkan): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        if (pilihan == 0) {
            System.out.println("Order artikel batal!");
            return; // exit the method if the order is cancelled
        }
        System.out.print("Masukkan nama pemesan: ");
        String namaPemesan = scanner.nextLine();

        System.out.print("Masukkan tanggal selesai pemesanan (format: YYYYMMDD): ");
        String tanggalSelesai = scanner.nextLine();
        String status = "Ordered"; // assuming the status is "Ordered" when an article is ordered

        orderId++;
        String orderIdString = "OID" + orderId;

        if (pilihan > 0 && pilihan <= listArtikel.size()) {
            Artikel artikel = listArtikel.get(pilihan - 1);

            Order order = new Order(artikel, namaPemesan, tanggalMulai, tanggalSelesai, status);
            listOrder.add(order);
            System.out.println("Order artikel berhasil.\n");
        } else {
            System.out.println("Nomor artikel yang dimasukkan tidak valid!\n");
        }

    }

    public static void orderPublikasi() {
        Scanner scanner = new Scanner(System.in);
        String tanggalMulai = "20240322";
        System.out.println("============================================================");
        System.out.println("                      Tambah Publikasi                      ");
        System.out.println("============================================================");
        System.out.print("Pilih Jenis Publikasi (1. Buku, 2. Artikel): ");
        int pilihan = scanner.nextInt();
        if (pilihan != 1 || pilihan != 2) {
            System.out.println("Input yang dimasukkan salah!\n");
        }
        switch (pilihan) {
            case 1:
                orderBuku();
                break;
            case 2:
                orderArtikel();
                break;
            default:
                break;
        }
    }

    public static void kelolaOrder() {
        System.out.println("============================================================");
        System.out.println("                      List Order                            ");
        System.out.println("============================================================");
        for (Order order : listOrder) {
            System.out.println("Order ID: " + order.getID());
            System.out.println("Tanggal Mulai: " + order.getTanggalMulai());
            System.out.println("Status: " + order.getStatus());
            System.out.println("----------------------------------------");
        }

    }

    public static void mainMenu() {
        System.out.println("============================================================");
        System.out.println("                    Welcome to Ceria Library                ");
        System.out.println("============================================================");
        System.out.print(
                "1. Lihat Publikasi\n2. Tambah Publikasi\n3. Lakukan Order\n4. Kelola Order\n5. Exit Program\nmenu: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        seedData();

        for (;;) {
            mainMenu();
            menu = scanner.nextInt();
            if (menu == 5) {
                System.out.println("Program selesai.");
                break;
            }
            switch (menu) {
                case 1:
                    System.out.println("============================================================");
                    System.out.println("                       Daftar Buku                          ");
                    System.out.println("============================================================");
                    showBuku();
                    System.out.println("============================================================");
                    System.out.println("                       Daftar Artikel                       ");
                    System.out.println("============================================================");
                    showArtikel();
                    break;
                case 2:
                    tambahPublikasi();
                    break;
                case 3:
                    orderPublikasi();
                    break;
                case 4:
                    kelolaOrder();
                default:
                    break;
            }
        }
        scanner.close();
    }
}
