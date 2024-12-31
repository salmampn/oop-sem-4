package uas_praktik_oop_gl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    private static ArrayList<salma_Item> daftarItems = new ArrayList<salma_Item>();
    private static ArrayList<salma_Customer> daftarCustomers = new ArrayList<salma_Customer>();
    private static ArrayList<salma_Order> daftarOrders = new ArrayList<salma_Order>();

    public static void tambahItem(salma_Item item) {
        daftarItems.add(item);
    }

    public static void tambahTiketKonser(salma_TiketKonser tiketKonser) {
        daftarItems.add(tiketKonser);
    }

    public static void tambahCustomer(salma_Customer customer) {
        daftarCustomers.add(customer);
    }

    public static void tambahRekamanKonser(salma_RekamanKonser rekamanKonser) {
        daftarItems.add(rekamanKonser);
    }

    public static void tambahMerchandise(salma_Merchandise merchandise) {
        daftarItems.add(merchandise);
    }

    public static void buatOrder(int customerId, int itemId, int qty) {
        salma_Customer customer = null;
        salma_Item itemTerpilih = null;
        for (salma_Customer c : daftarCustomers) {
            if (c.getCustomerId() == customerId) {
                customer = c;
                break;
            }
        }
        for (salma_Item item : daftarItems) {
            if (item.getItemId() == itemId) {
                itemTerpilih = item;
                break;
            }
        }
        if (customer == null || itemTerpilih == null) {
            System.out.println("Customer atau Item tidak ditemukan");
            return;
        }
        double totalHarga = itemTerpilih.getHarga() * qty;
        salma_Order order = new salma_Order(daftarOrders.size() + 1, customer, itemTerpilih, qty, totalHarga);
        daftarOrders.add(order);
        System.out.println("Pesanan berhasil dibuat");
    }

    public static void cetakSemuaOrder() {
        System.out.println("Daftar Semua Pesanan:");
        for (salma_Order order : daftarOrders) {
            System.out.println(order.printDetailOrder());
            System.out.println();
        }
    }

    public static salma_Customer findCustomerById(int customerId) {
        for (salma_Customer customer : daftarCustomers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public static salma_Item findItemById(int itemId) {
        for (salma_Item item : daftarItems) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public static int getItemStock(int itemId) {
        for (salma_Item item : daftarItems) {
            if (item.getItemId() == itemId) {
                return item.getStok();
            }
        }
        return 0;
    }

    public static String getItemName(int itemId) {
        for (salma_Item item : daftarItems) {
            if (item.getItemId() == itemId) {
                return item.getNama();
            }
        }
        return "";
    }

    public static void menuTambahTiketKonser() {
        int itemId = daftarItems.size() + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Tambah Tiket Konser:");
        System.out.print("Nama Tiket: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Tiket: ");
        float harga = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Stok Tiket: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama Artis: ");
        String namaArtis = scanner.nextLine();
        System.out.print("Tanggal Konser (dd/mm/yyyy): ");
        String tanggalKonser = scanner.nextLine();
        System.out.print("Venue: ");
        String venue = scanner.nextLine();
        salma_TiketKonser tiketKonser = new salma_TiketKonser(itemId, nama, harga, stok, namaArtis, tanggalKonser,
                venue);
        tambahTiketKonser(tiketKonser);
        System.out.println("Tiket Konser berhasil ditambahkan");
    }

    public static void menuTambahMerchandise() {
        int itemId = daftarItems.size() + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Tambah Merchandise:");
        System.out.print("Nama Merchandise: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Merchandise: ");
        float harga = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Stok Merchandise: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama Merk: ");
        String namaMerk = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        salma_Merchandise merchandise = new salma_Merchandise(itemId, nama, harga, stok, namaMerk, kategori);
        tambahMerchandise(merchandise);
    }

    public static void menuTambahRekamanKonser() {
        int itemId = daftarItems.size() + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Tambah Rekaman Konser:");
        System.out.print("Nama Rekaman: ");
        String nama = scanner.nextLine();
        // System.out.print("Harga Rekaman:");
        // float harga = scanner.nextFloat();
        // scanner.nextLine();
        System.out.print("Tanggal Konser (dd/mm/yyyy): ");
        String tanggalKonser = scanner.nextLine();
        System.out.print("Venue: ");
        String venue = scanner.nextLine();
        System.out.print("Link Rekaman: ");
        String linkRekaman = scanner.nextLine();
        salma_RekamanKonser rekamanKonser = new salma_RekamanKonser(itemId, nama, 0, 0, tanggalKonser,
                venue, linkRekaman);
        tambahRekamanKonser(rekamanKonser);
    }

    public static void tambahBarang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Tambah Barang:");
        System.out.println("1. Tiket Konser");
        System.out.println("2. Merchandise");
        System.out.println("3. Rekaman Konser");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Pilihan: ");

        int menu = scanner.nextInt();
        scanner.nextLine();
        if (menu < 1 || menu > 4) {
            System.out.println("Pilihan tidak valid. Silahkan pilih opsi yang sesuai.");
        }
        switch (menu) {
            case 1:
                menuTambahTiketKonser();
                break;
            case 2:
                menuTambahMerchandise();
                break;
            case 3:
                menuTambahRekamanKonser();
                break;
            case 4:
                return;
            default:
                break;
        }
    }

    public static void lihatBarang() {
        System.out.println("Daftar Barang:");
        for (salma_Item item : daftarItems) {
            System.out.println("ID Barang: " + item.getItemId());
            System.out.println("Nama: " + item.getNama());
            System.out.println("Harga: " + item.getHarga());
            if (item instanceof salma_TiketKonser) {
                salma_TiketKonser tiketKonser = (salma_TiketKonser) item;
                System.out.println(tiketKonser.getDataTiket());
            } else if (item instanceof salma_Merchandise) {
                salma_Merchandise merchandise = (salma_Merchandise) item;
                System.out.println(merchandise.getDataMerch());
            } else if (item instanceof salma_RekamanKonser) {
                salma_RekamanKonser rekamanKonser = (salma_RekamanKonser) item;
                System.out.println(rekamanKonser.getDataRekaman());
            }
            System.out.println();
        }
    }

    public static void menuTambahCustomer() {
        int customerId = daftarCustomers.size() + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Daftar Pelanggan Baru:");
        System.out.print("Nama Pelanggan: ");
        String nama = scanner.nextLine();
        // format email sesuai dengan format yaitu nama@example.com, jika tidak sesuai
        // buat exception handlingnya
        class InvalidEmailException extends Exception {
            public InvalidEmailException(String message) {
                super(message);
            }
        }
        System.out.print("Email: ");
        String email = scanner.nextLine();
        try {
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                throw new InvalidEmailException(
                        "Error: Format email tidak valid. Silahkan masukkan email dengan format yang benar (contoh: nama@example.com)");
            }
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
            return;
        }
        // format nomor telepon sesuai dengan format yaitu harus dimulai dengan "08" dan
        // memiliki total 12 digit, jika tidak sesuai
        // buat exception handlingnya
        class InvalidPhoneNumberException extends Exception {
            public InvalidPhoneNumberException(String message) {
                super(message);
            }
        }
        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();
        try {
            if (!nomorTelepon.matches("^08\\d{10}$")) {
                throw new InvalidPhoneNumberException(
                        "Error: Format nomor telepon tidak valid. Nomor telepon harus dimulai dengan \"08\" dan memiliki total 12 digit");
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
            return;
        }
        salma_Customer customer = new salma_Customer(customerId, nama, email, nomorTelepon);
        tambahCustomer(customer);
        System.out.println("Pelanggan berhasil ditambahkan");
    }

    public static void menuBuatPesanan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Buat Pesanan:");
        // jika id pelanggan tidak ditemukan tampilkan pesan
        class CustomerNotFoundException extends Exception {
            public CustomerNotFoundException(String message) {
                super(message);
            }
        }
        System.out.print("ID Pelanggan: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        try {
            salma_Customer customer = findCustomerById(customerId);
            if (customer == null) {
                throw new CustomerNotFoundException("Error: Pelanggan dengan ID " + customerId
                        + " tidak ditemukan dalam database. Silahkan daftarkan pelanggan terlebih dahulu");
            }
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.print("ID Barang: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        // jika stok barang tidak mencukupi tampilkan pesan
        class InsufficientStockException extends Exception {
            public InsufficientStockException(String message) {
                super(message);
            }
        }
        System.out.print("Jumlah Barang: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        int stock = getItemStock(itemId);
        try {
            if (qty > stock) {
                throw new InsufficientStockException("Error: Maaf, stok " + getItemName(itemId)
                        + " tidak mencukupi untuk pesanan Anda. Silahkan pesan barang lain atau kurangi jumlah pesanan Anda. Stok "
                        + getItemName(itemId) + " saat ini: " + stock + " buah");
            }
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (stock > qty) {
            salma_Item item = findItemById(itemId);
            item.kurangiStok(qty);
            buatOrder(customerId, itemId, qty);
        }
        // else {
        // Item item = findItemById(itemId);
        // item.kurangiStok();
        // }
        // buatOrder(customerId, itemId, qty);
    }

    public static void mainMenu() {
        System.out.println(
                "==========================Menu Kasir Festival Musik==========================");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Lihat Semua Barang");
        System.out.println("3. Daftar Pelanggan Baru");
        System.out.println("4. Buat Pesanan");
        System.out.println("5. Lihat Semua Pesanan");
        System.out.println("6. Keluar");
        System.out.print("Pilihan: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            mainMenu();
            int menu = scanner.nextInt();
            scanner.nextLine();
            if (menu < 1 || menu > 6) {
                System.out.println("Pilihan tidak valid. Silahkan pilih opsi yang sesuai.");
            }
            switch (menu) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    lihatBarang();
                    break;
                case 3:
                    menuTambahCustomer();
                    break;
                case 4:
                    menuBuatPesanan();
                    break;
                case 5:
                    cetakSemuaOrder();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    return;
                default:
                    break;
            }
        }
    }

}
