package Tugas;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    private static ArrayList<Manager> managers = new ArrayList<>();
    private static ArrayList<Tetap> tetaps = new ArrayList<>();
    private static ArrayList<Magang> magangs = new ArrayList<>();

    public static String formatGaji(int gaji) {
        DecimalFormat kursIDR = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator('.');
        formatRp.setGroupingSeparator('.');

        kursIDR.setDecimalFormatSymbols(formatRp);

        return kursIDR.format(gaji);
    }

    public static void mainMenu() {
        System.out.println("---------------Program Data Karyawan---------------");
        System.out.println("1. Lihat Karyawan");
        System.out.println("2. Tambah Karyawan");
        System.out.println("3. Keluar");
        System.out.print("Pilih: ");
    }

    public static void showKaryawan() {
        System.out.println("---------------Daftar Manajer---------------");
        if (!managers.isEmpty()) {
            for (int i = 0; i < managers.size(); i++) {
                System.out.println("ID      : " + managers.get(i).getId());
                System.out.println("Nama    : " + managers.get(i).getNama());
                System.out.println("Gaji    : " + formatGaji(managers.get(i).getGaji()));
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("Tidak ada");
        }

        System.out.println("------------Daftar Pegawai Tetap-------------");
        if (!tetaps.isEmpty()) {
            for (int i = 0; i < tetaps.size(); i++) {
                System.out.println("ID      : " + tetaps.get(i).getId());
                System.out.println("Nama    : " + tetaps.get(i).getNama());
                System.out.println("Gaji    : " + formatGaji(tetaps.get(i).getGaji()));
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("Tidak ada");
        }

        System.out.println("------------Daftar Pegawai Magang------------");
        if (!magangs.isEmpty()) {
            for (int i = 0; i < magangs.size(); i++) {
                System.out.println("ID      : " + magangs.get(i).getId());
                System.out.println("Nama    : " + magangs.get(i).getNama());
                System.out.println("Gaji    : " + formatGaji(magangs.get(i).getGaji()));
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("Tidak ada");
        }

        System.out.println();
    }

    public static void addManajer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Tambah Manajer---------------");
        String id = String.format("M%d", (managers.size() + 1));
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Gaji: ");
        int gaji = scanner.nextInt();
        managers.add(new Manager(id, nama, gaji));
        System.out.println("Manajer baru berhasil ditambahkan");
    }

    public static void addTetap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Tambah Karyawan Tetap---------------");
        String id = String.format("R%d", (tetaps.size() + 1));
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Gaji: ");
        int gaji = scanner.nextInt();
        tetaps.add(new Tetap(id, nama, gaji));
        System.out.println("Karyawan Tetap baru berhasil ditambahkan");
    }

    public static void addMagang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Tambah Karyawan Magang---------------");
        String id = String.format("I%d", (magangs.size() + 1));
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Gaji: ");
        int gaji = scanner.nextInt();
        magangs.add(new Magang(id, nama, gaji));
        System.out.println("Karyawan Magang baru berhasil ditambahkan");
    }

    public static void addKaryawan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Tambah Karyawan---------------");
        System.out.println("1. Manajer");
        System.out.println("2. Karyawan Tetap");
        System.out.println("3. Karyawan Magang");
        System.out.print("Pilih: ");
        int pilih = scanner.nextInt();

        switch (pilih) {
            case 1:
                addManajer();
                break;
            case 2:
                addTetap();
                break;
            case 3:
                addMagang();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        int menu;
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            mainMenu();
            menu = scanner.nextInt();
            if (menu == 3) {
                System.out.println("Program selesai");
                break;
            }
            switch (menu) {
                case 1:
                    showKaryawan();
                    break;
                case 2:
                    addKaryawan();
                    break;
                default:
                    break;
            }
        }
    }
}
