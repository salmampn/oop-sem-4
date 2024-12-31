package Tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Aktor> listAktor = new ArrayList<>();
    private static ArrayList<Celebgram> listCelebgram = new ArrayList<>();
    private static ArrayList<Baliho> listBaliho = new ArrayList<>();
    private static ArrayList<Majalah> listMajalah = new ArrayList<>();
    private static ArrayList<Order> listOrder = new ArrayList<>();
    private static String tanggalUjian = "22052024";

    public static void seedData() {
        listAktor.add(new Aktor("Chris Evans", 200000000, 30, 170, 60, 100000, "Captain America Lovers"));
        listAktor.add(new Aktor("Robert Downey Jr", 240000000, 31, 171, 61, 120000, "Ironman Lovers"));
        listAktor.add(new Aktor("Chris Hemsworth", 280000000, 32, 172, 62, 140000, "Thor Lovers"));
        listCelebgram.add(new Celebgram("Awkarin", 20000000, 25, 165, 45, 100000, "Instagram", "Furnitur"));
        listCelebgram.add(new Celebgram("Anya Geraldine", 30000000, 26, 166, 46, 120000, "Twitter", "Makanan"));
        listCelebgram.add(new Celebgram("Devina Aurel", 28000000, 27, 167, 47, 140000, "Youtube", "Tanaman"));
        listBaliho.add(new Baliho("Baliho Jakarta Pusat", 50000000, 6, "Jakarta Pusat"));
        listBaliho.add(new Baliho("Baliho Jakarta Barat", 20000000, 8, "Jakarta Barat"));
        listBaliho.add(new Baliho("Baliho Jakarta Utara", 70000000, 9, "Jakarta Utara"));
        listMajalah.add(new Majalah("Home Decor", 5000000, 15, "Halaman 2", "Furnitur"));
        listMajalah.add(new Majalah("Sedap", 3000000, 18, "Halaman 3", "Makanan"));
        listMajalah.add(new Majalah("Otomotif", 10000000, 21, "Halaman 4", "Tanaman"));
    }

    public static void mainMenu() {
        System.out.println("=====================================");
        System.out.println("        Wemen Marketing Agent       ");
        System.out.println("=====================================");
        System.out.println("1. Penambahan Media");
        System.out.println("2. Penyewaan Media");
        System.out.println("3. Check Employment / Rental");
        System.out.println("4. Credits");
        System.out.println("5. Exit");
        System.out.println("=====================================");
        System.out.print("Pilih Menu (1-5): ");
    }

    public static void tambahMedia() {
        Scanner scanner = new Scanner(System.in);
        int pilih;
        System.out.println("=====================================");
        System.out.println("        Wemen Marketing Agent       ");
        System.out.println("=====================================");
        System.out.println("1. Celebgram");
        System.out.println("2. Majalah");
        System.out.println("=====================================");
        System.out.print("Pilih Media(1-2): ");
        pilih = scanner.nextInt();
        switch (pilih) {
            case 1:
                tambahCelebgram();
                break;
            case 2:
                tambahMajalah();
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    public static void pilihKategori() {
        System.out.println("=====================================");
        System.out.println("1. Furnitur");
        System.out.println("2. Makanan");
        System.out.println("3. Tanaman");
        System.out.println("4. Otomotif");
        System.out.println("5. Musik");
        System.out.println("=====================================");
        System.out.print("Pilih Kategori (1-5): ");
    }

    public static void tambahCelebgram() {
        Scanner scanner = new Scanner(System.in);
        int kategori;
        pilihKategori();
        kategori = scanner.nextInt();
        switch (kategori) {
            case 1:
                tambahCelebgramByCategory("Furnitur", scanner);
                break;
            case 2:
                tambahCelebgramByCategory("Makanan", scanner);
                break;
            case 3:
                tambahCelebgramByCategory("Tanaman", scanner);
                break;
            case 4:
                tambahCelebgramByCategory("Otomotif", scanner);
                break;
            case 5:
                tambahCelebgramByCategory("Musik", scanner);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    public static void tambahCelebgramByCategory(String category, Scanner scanner) {
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan tinggi badan: ");
        int tinggiBadan = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan berat badan: ");
        int beratBadan = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan jumlah followers: ");
        int followers = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan media sosial yang digunakan: ");
        String akunMedia = scanner.nextLine();

        Celebgram celebgram = new Celebgram(nama, harga, umur, tinggiBadan, beratBadan,
                followers, akunMedia,
                category);
        listCelebgram.add(celebgram);
        System.out.println("Media baru berhasil ditambahkan.\n");
    }

    public static void tambahMajalah() {
        Scanner scanner = new Scanner(System.in);
        int kategori;
        pilihKategori();
        kategori = scanner.nextInt();
        switch (kategori) {
            case 1:
                tambahMajalahByCategory("Furnitur", scanner);
                break;
            case 2:
                tambahMajalahByCategory("Makanan", scanner);
                break;
            case 3:
                tambahMajalahByCategory("Tanaman", scanner);
                break;
            case 4:
                tambahMajalahByCategory("Otomotif", scanner);
                break;
            case 5:
                tambahMajalahByCategory("Musik", scanner);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    public static void tambahMajalahByCategory(String category, Scanner scanner) {
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga:");
        int harga = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan luas: ");
        int luas = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Masukkan letak halaman promosi: ");
        String letak = scanner.nextLine();

        Majalah majalah = new Majalah(nama, harga, luas, letak, category);
        listMajalah.add(majalah);
        System.out.println("Media baru berhasil ditambahkan.\n");
    }

    public static void pasangIklan() {
        Scanner scanner = new Scanner(System.in);
        int kategori;
        System.out.println("=====================================");
        System.out.println("        Wemen Marketing Agent       ");
        pilihKategori();
        kategori = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        if (kategori >= 1 && kategori <= 5) {
            System.out.print("Tanggal Mulai (DDMMYYYY): ");
            String tanggal = scanner.nextLine();
            System.out.print("Banyak hari penyewaan: ");
            int jangkaWaktu = scanner.nextInt();
            sewaMedia(tanggal, jangkaWaktu);
        } else {
            System.out.println("Pilihan tidak tersedia");
        }
    }

    public static void sewaMedia(String tanggal, int jangkaWaktu) {
        Scanner scanner = new Scanner(System.in);
        int media;
        System.out.println("=====================================");
        System.out.println("1. Aktor");
        System.out.println("2. Celebgram");
        System.out.println("3. Majalah");
        System.out.println("4. Baliho");
        System.out.print("Pilih Media (1-4): ");
        media = scanner.nextInt();
        switch (media) {
            case 1:
                sewaAktor(tanggal, jangkaWaktu);
                break;
            case 2:
                sewaCelebgram(tanggal, jangkaWaktu);
                break;
            case 3:
                sewaMajalah(tanggal, jangkaWaktu);
                break;
            case 4:
                sewaBaliho(tanggal, jangkaWaktu);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    public static void sewaAktor(String tanggal, int jangkaWaktu) {
        Scanner scanner = new Scanner(System.in);
        int uang;
        int total = 0;
        showAktor();
        System.out.print("Masukkan nomor media: ");
        int selectedActorIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Buat objek Order untuk aktor yang dipilih
        Aktor selectedActor = listAktor.get(selectedActorIndex - 1); // Kurangi 1 karena index dimulai dari 0
        System.out.print("Masukkan uang untuk pembayaran: ");
        uang = scanner.nextInt();
        total = selectedActor.getHarga() * jangkaWaktu;
        if (uang < total) {
            System.out.println("Uang tidak cukup");
            return;
        } else {
            Order order = new Order(selectedActor, "Aktor", tanggal, jangkaWaktu);
            // Tambahkan order ke dalam listOrder
            listOrder.add(order);
            // Konfirmasi pesanan kepada pengguna
            System.out.println("Pesanan Anda telah berhasil diajukan.");
        }
    }

    public static void showAktor() {
        System.out.println("=====================================");
        int i = 1;
        for (Aktor aktor : listAktor) {
            System.out.println("No\t\t: " + i);
            System.out.println("Media\t\t: Aktor");
            System.out.println("Nama\t\t: " + aktor.getNama());
            System.out.println("Umur\t\t: " + aktor.getUmur());
            System.out.println("Tinggi Badan\t: " + aktor.getTinggiBadan());
            System.out.println("Berat Badan\t: " + aktor.getBeratBadan());
            System.out.println("Jumlah Fans\t: " + aktor.getFans());
            System.out.println("Nama Fansclub\t: " + aktor.getFanClub());
            System.out.println("Harga\t\t: " + aktor.getHarga());
            System.out.println("=====================================");
            i++;
        }
    }

    public static void sewaCelebgram(String tanggal, int jangkaWaktu) {
        Scanner scanner = new Scanner(System.in);
        int uang;
        int total = 0;
        showCelebgram();
        System.out.print("Masukkan nomor media: ");
        int selectedCelebgramIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Buat objek Order untuk celebgram yang dipilih
        Celebgram selectedCelebgram = listCelebgram.get(selectedCelebgramIndex - 1); // Kurangi 1 karena index dimulai
                                                                                     // dari 0
        System.out.print("Masukkan uang untuk pembayaran: ");
        uang = scanner.nextInt();
        total = selectedCelebgram.getHarga() * jangkaWaktu;
        if (uang < total) {
            System.out.println("Uang tidak cukup");
            return;
        } else {
            Order order = new Order(selectedCelebgram, "Celebgram", tanggal, jangkaWaktu);
            // Tambahkan order ke dalam listOrder
            listOrder.add(order);
            // Konfirmasi pesanan kepada pengguna
            System.out.println("Pesanan Anda telah berhasil diajukan.");
        }
    }

    public static void showCelebgram() {
        System.out.println("=====================================");
        int i = 1;
        for (Celebgram celebgram : listCelebgram) {
            System.out.println("No\t\t: " + i);
            System.out.println("Media\t\t: Celebgram");
            System.out.println("Nama\t\t: " + celebgram.getNama());
            System.out.println("Umur\t\t: " + celebgram.getUmur());
            System.out.println("Tinggi Badan\t: " + celebgram.getTinggiBadan());
            System.out.println("Berat Badan\t: " + celebgram.getBeratBadan());
            System.out.println("Followers\t: " + celebgram.getFollowers());
            System.out.println("Akun Media\t: " + celebgram.getAkunMedia());
            System.out.println("Harga\t\t: " + celebgram.getHarga());
            System.out.println("=====================================");
            i++;
        }
    }

    public static void sewaMajalah(String tanggal, int jangkaWaktu) {
        Scanner scanner = new Scanner(System.in);
        int uang;
        int total = 0;
        showMajalah();
        System.out.print("Masukkan nomor media: ");
        int selectedMajalahIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Buat objek Order untuk majalah yang dipilih
        Majalah selectedMajalah = listMajalah.get(selectedMajalahIndex - 1); // Kurangi 1 karena index dimulai dari 0
        System.out.print("Masukkan uang untuk pembayaran: ");
        uang = scanner.nextInt();
        total = selectedMajalah.getHarga() * jangkaWaktu;
        if (uang < total) {
            System.out.println("Uang tidak cukup");
            return;
        } else {
            Order order = new Order(selectedMajalah, "Majalah", tanggal, jangkaWaktu);
            // Tambahkan order ke dalam listOrder
            listOrder.add(order);
            // Konfirmasi pesanan kepada pengguna
            System.out.println("Pesanan Anda telah berhasil diajukan.");
        }
    }

    public static void showMajalah() {
        System.out.println("=====================================");
        int i = 1;
        for (Majalah majalah : listMajalah) {
            System.out.println("No\t\t: " + i);
            System.out.println("Media\t\t: Majalah");
            System.out.println("Nama\t\t: " + majalah.getNama());
            System.out.println("Luas\t\t: " + majalah.getLuas());
            System.out.println("Letak Halaman\t: " + majalah.getLetak());
            System.out.println("Harga\t\t: " + majalah.getHarga());
            System.out.println("=====================================");
            i++;
        }
    }

    public static void showOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        Wemen Marketing Agent       ");
        System.out.println("=====================================");
        int i = 1;
        if (listOrder.isEmpty()) {
            System.out.println("           Tidak ada order          ");
            System.out.println("=====================================");
        } else {
            for (Order order : listOrder) {
                System.out.println("No\t\t: " + i);
                System.out.println("Media\t\t: " + order.getBidang());
                System.out.println("Nama\t\t: " + order.getMediaPromosi().getNama());
                System.out.println("Tanggal\t\t: " + order.getTanggal());
                System.out.println("Durasi Kontrak\t: " + order.getJangkaWaktu());
                System.out.println("Harga\t\t: " + order.getMediaPromosi().getHarga());
                System.out.println("=====================================");
                i++;
            }
        }
        System.out.println("1. Batalkan Order");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("=====================================");
        System.out.print("Pilih Menu (1-2): ");
        int menu = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        switch (menu) {
            case 1:
                System.out.print("Masukkan nomor order yang ingin dibatalkan: ");
                int selectedOrderIndex = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                Order selectedOrder = listOrder.get(selectedOrderIndex - 1); // Kurangi 1 karena index dimulai dari 0
                if (selectedOrder.getTanggal().equals(tanggalUjian)) {
                    System.out.println("Pesanan ini tidak bisa dibatalkan.");
                } else {
                    listOrder.remove(selectedOrderIndex - 1);
                    System.out.println("Pesanan berhasil dibatalkan.");
                }
                break;
            case 2:
                break;
        }
    }

    public static void sewaBaliho(String tanggal, int jangkaWaktu) {
        Scanner scanner = new Scanner(System.in);
        int uang;
        int total = 0;
        showBaliho();
        System.out.print("Masukkan nomor media: ");
        int selectedBalihoIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Buat objek Order untuk baliho yang dipilih
        Baliho selectedBaliho = listBaliho.get(selectedBalihoIndex - 1); // Kurangi 1 karena index dimulai dari 0
        System.out.print("Masukkan uang untuk pembayaran: ");
        uang = scanner.nextInt();
        total = selectedBaliho.getHarga() * jangkaWaktu;
        if (uang < total) {
            System.out.println("Uang tidak cukup");
            return;
        } else {
            Order order = new Order(selectedBaliho, "Baliho", tanggal, jangkaWaktu);
            // Tambahkan order ke dalam listOrder
            listOrder.add(order);
            // Konfirmasi pesanan kepada pengguna
            System.out.println("Pesanan Anda telah berhasil diajukan.");
        }
    }

    public static void showBaliho() {
        System.out.println("=====================================");
        int i = 1;
        for (Baliho baliho : listBaliho) {
            System.out.println("No\t\t: " + i);
            System.out.println("Media\t\t: Baliho");
            System.out.println("Nama\t\t: " + baliho.getNama());
            System.out.println("Luas\t\t: " + baliho.getLuas());
            System.out.println("Lokasi\t\t: " + baliho.getLetak());
            System.out.println("Harga\t\t: " + baliho.getHarga());
            System.out.println("=====================================");
            i++;
        }
    }

    public static void credits() {
        System.out.println("=====================================");
        System.out.println("        Wemen Marketing Agent       ");
        System.out.println("=====================================");
        System.out.println("Name\t: Salma Manda Putri Nabilah");
        System.out.println("NIM\t: 00000077712");
        System.out.println("=====================================");
        System.out.print("Tekan enter untuk melanjutkan");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
                    tambahMedia();
                    break;
                case 2:
                    pasangIklan();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:
                    credits();
                    break;
                default:
                    break;
            }
        }
    }
}
