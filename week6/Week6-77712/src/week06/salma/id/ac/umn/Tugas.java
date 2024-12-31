package week06.salma.id.ac.umn;

import java.util.Scanner;
import java.util.ArrayList;

public class Tugas {

	private static int idHp = 1;
	private static int idV = 1;
	private static ArrayList<Handphone> handphones = new ArrayList<>();
	private static ArrayList<Voucher> vouchers = new ArrayList<>();
	private static ArrayList<Order> orders = new ArrayList<>();

	public static void barangBaru() {
		String name, warna;
		double price, ppn;
		int stock;

		Scanner s = new Scanner(System.in);

		System.out.print("Voucher / Handphone (v/h) : ");
		String type = s.nextLine();

		if ("v".equals(type)) {
			System.out.print("Nama : ");
			name = s.nextLine();
			System.out.print("Harga : ");
			price = s.nextDouble();
			System.out.print("Stock : ");
			stock = s.nextInt();
			System.out.print("PPN : ");
			ppn = s.nextDouble();

			vouchers.add(new Voucher(Tugas.idV, name, price, stock, ppn));
			Tugas.idV++;
			System.out.println("Voucher telah berhasil diinput");
		} else if ("h".equals(type)) {
			System.out.print("Nama : ");
			name = s.nextLine();
			System.out.print("Harga : ");
			price = s.nextDouble();
			System.out.print("Stock : ");
			stock = s.nextInt();
			s.nextLine();
			System.out.print("Warna : ");
			warna = s.nextLine();

			handphones.add(new Handphone(Tugas.idHp, name, price, stock, warna));
			Tugas.idHp++;
			System.out.println("Handphone telah berhasil diinput");
		}
	}

	public static void lihatPesanan() {
		if (orders.isEmpty()) {
			System.out.println("Tidak ada order list. Silahkan order dulu");
		} else {
			for (Order order : orders) {
				if (order.getHandphone() != null) {
					System.out.println("ID     : 0H" + order.getHandphone().getId());
					System.out.println("Nama   : " + order.getHandphone().getNama());
					System.out.println("Jumlah : " + order.getJumlah());
					System.out.println("Total  : " + order.getJumlah() * order.getHandphone().getHarga());
					System.out.println("--------------------------------------------------");
				} else if (order.getVoucher() != null) {
					System.out.println("ID     : 0V" + order.getVoucher().getId());
					System.out.println("Nama   : " + order.getVoucher().getNama());
					System.out.println("Jumlah : " + order.getJumlah());
					System.out.println("Total  : " + order.getJumlah() * order.getVoucher().getHargaJual());
					System.out.println("--------------------------------------------------");
				}
			}
		}
	}

	public static void pesanHandphone() {
		int id, qty, jumlah, total, stock;

		Handphone hp;

		Scanner scan = new Scanner(System.in);

		if (handphones.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (Handphone handphone : handphones) {
				System.out.println("ID    : " + handphone.getId());
				System.out.println("Nama  : " + handphone.getNama() + " " + handphone.getWarna());
				System.out.println("Stock : " + handphone.getStock());
				System.out.println("Harga : " + handphone.getHarga());
				System.out.println("--------------------------------------------------");
			}

			System.out.println("Ketik 0 untuk batal");
			do {
				System.out.print("Pesan barang (ID) : ");
				id = scan.nextInt();

				if (id == 0) {
					break;
				}

				stock = handphones.get(id - 1).getStock();
				System.out.print("Masukkan Jumlah : ");
				qty = scan.nextInt();

				if (qty == 0) {
					break;
				}

				if (qty > stock || qty <= 0) {
					if (qty <= 0) {
						System.out.println("Jumlah tidak bisa dibawah atau sama dengan 0");
						break;
					} else {
						System.out.println("Stock tidak mencukupi\n");
						break;
					}
				}

				total = (int) (handphones.get(id - 1).getHarga() * qty);
				System.out.println(qty + " @ " + handphones.get(id - 1).getNama() + " dengan total harga " + total);
				System.out.print("Masukkan Jumlah Uang : ");
				jumlah = scan.nextInt();

				if (jumlah >= total) {
					System.out.println("Berhasil dipesan");
					handphones.get(id - 1).minusStock(qty);
					hp = handphones.get(id - 1);
					orders.add(new Order(id, hp, qty));
					break;
				} else {
					System.out.println("Jumlah uang tidak mencukupi");
					break;
				}
			} while (true);
		}
	}

	public static void pesanVoucher() {
		int id, qty, jumlah, total, stock;

		Voucher vc;

		Scanner scan = new Scanner(System.in);

		if (vouchers.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (Voucher voucher : vouchers) {
				System.out.println("ID      : " + voucher.getId());
				System.out.println("Nama    : " + voucher.getNama());
				System.out.println("Nominal : " + voucher.getHarga());
				System.out.println("Stock   : " + voucher.getStock());
				System.out.println("Harga   : " + voucher.getHargaJual());
				System.out.println("--------------------------------------------------");
			}

			System.out.println("Ketik 0 untuk batal");
			do {
				System.out.print("Pesan barang (ID) : ");
				id = scan.nextInt();

				if (id == 0) {
					break;
				}

				stock = vouchers.get(id - 1).getStock();
				System.out.print("Masukkan Jumlah : ");
				qty = scan.nextInt();

				if (qty == 0) {
					break;
				}

				if (qty > stock || qty <= 0) {
					if (qty <= 0) {
						System.out.println("Jumlah tidak bisa dibawah atau sama dengan 0");
						break;
					} else {
						System.out.print("Stock tidak mencukupi");
						break;
					}
				}

				total = (int) (vouchers.get(id - 1).getHargaJual() * qty);
				System.out.println(qty + " @ " + vouchers.get(id - 1).getNama() + " dengan total harga " + total);
				System.out.print("Masukkan Jumlah Uang : ");
				jumlah = scan.nextInt();

				if (jumlah >= total) {
					System.out.println("Berhasil dipesan");
					vouchers.get(id - 1).minusStock(qty);
					vouchers.get(id - 1).minusStock(qty);
					vc = vouchers.get(id - 1);
					orders.add(new Order(id, vc, qty));
					break;
				} else {
					System.out.println("Jumlah uang tidak mencukupi");
					break;
				}
			} while (true);
		}
	}

	public static void pesanBarang() {
		Scanner s = new Scanner(System.in);

		System.out.println("Daftar Barang Toko Voucher & HP");
		System.out.println("1. Handphone\n2. Voucher");
		System.out.print("Pilihan : ");
		int menu = s.nextInt();

		switch (menu) {
			case 1:
				pesanHandphone();
				break;
			case 2:
				pesanVoucher();
				break;
			default:
				System.out.println("Input Invalid");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int choice = 1;

		do {
			System.out.println("------------ Menu Toko Voucher & HP ------------");
			System.out.println("1. Pesan Barang\n2. Lihat Pesanan\n3. Barang Baru\n0. Exit");
			System.out.print("Pilihan : ");
			choice = s.nextInt();

			switch (choice) {
				case 1:
					pesanBarang();
					break;
				case 2:
					lihatPesanan();
					break;
				case 3:
					barangBaru();
					break;
				default:
					System.out.println("Input invalid");
			}
		} while (choice != 0);

		System.out.println("Exiting program...");

	}

}
