package week8.salma.id.ac.umn;

import java.util.Scanner;

import Model.Barang;
import Model.Handphone;
import Model.Order;
import Model.Voucher;

import java.util.ArrayList;

public class Tugas {

	private static int idHp = 1;
	private static int idV = 1;
	private static ArrayList<Order> orders = new ArrayList<>();
	private static ArrayList<Barang> barangs = new ArrayList<>();

	public static void barangBaru() {
		String name, warna, id;
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

			id = (String) "V0" + Tugas.idV;
			barangs.add(new Voucher(id, name, price, stock, ppn));
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

			id = (String) "H0" + Tugas.idHp;
			barangs.add(new Handphone(id, name, price, stock, warna));
			Tugas.idHp++;
			System.out.println("Handphone telah berhasil diinput");
		}
	}

	public static void lihatPesanan() {
		int num = 0;

		if (orders.isEmpty()) {
			System.out.println("Tidak ada order list. Silahkan order dulu");
		} else {
			for (Order order : orders) {
				if (order.getHandphone() != null) {
					System.out.println("ID     : O" + order.getHandphone().getId() + "-" + num);
					System.out.println("Nama   : " + order.getHandphone().getNama());
					System.out.println("Jumlah : " + order.getJumlah());
					System.out.println("Total  : " + order.getJumlah() * order.getHandphone().getHarga());
					System.out.println("--------------------------------------------------");
				} else if (order.getVoucher() != null) {
					System.out.println("ID     : O" + order.getVoucher().getId() + "-" + num);
					System.out.println("Nama   : " + order.getVoucher().getNama());
					System.out.println("Jumlah : " + order.getJumlah());
					System.out.println("Total  : " + order.getJumlah() * order.getVoucher().getHargaJual());
					System.out.println("--------------------------------------------------");
				}
				num++;
			}
		}
	}

	public static void pesanBarang() {
		int qty, jumlah, total, stock = 0, found = 0, hargaJual = 0;
		String id, nama = "", status = "";

		Scanner scan = new Scanner(System.in);

		Handphone handphone = null;
		Voucher voucher = null;

		if (barangs.isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println("Daftar Barang Toko Voucher & HP");

			for (Barang barang : barangs) {
				if (barang instanceof Handphone) {
					handphone = (Handphone) barang;
					System.out.println("ID    : " + handphone.getId());
					System.out.println("Nama  : " + handphone.getNama() + " " + handphone.getWarna());
					System.out.println("Stock : " + handphone.getStock());
					System.out.println("Harga : " + handphone.getHarga());
					System.out.println("--------------------------------------------------");
				}
			}

			for (Barang barang : barangs) {
				if (barang instanceof Voucher) {
					voucher = (Voucher) barang;
					System.out.println("ID      : " + voucher.getId());
					System.out.println("Nama    : " + voucher.getNama());
					System.out.println("Nominal : " + voucher.getHarga());
					System.out.println("Stock   : " + voucher.getStock());
					System.out.println("Harga   : " + voucher.getHargaJual());
					System.out.println("--------------------------------------------------");
				}
			}

			System.out.println("Ketik 0 untuk batal");

			do {
				System.out.print("Pesan barang (ID) : ");
				id = scan.next();

				if ("0".equals(id)) {
					break;
				}

				for (Barang barang : barangs) {
					if (barang.getId().equals(id)) {
						found = 1;

						if (barang instanceof Handphone) {
							handphone = (Handphone) barang;
							stock = handphone.getStock();
							nama = handphone.getNama();
							hargaJual = (int) handphone.getHarga();
							status = "hp";
						} else if (barang instanceof Voucher) {
							voucher = (Voucher) barang;
							stock = voucher.getStock();
							hargaJual = (int) voucher.getHargaJual();
							nama = voucher.getNama();
							status = "vc";
						}
					}
				}

				if (found != 1) {
					System.out.println("Barang tidak ditemukan");
					break;
				}

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

				total = hargaJual * qty;
				System.out.println(qty + " @ " + nama + " dengan total harga " + total);
				System.out.print("Masukkan Jumlah Uang : ");
				jumlah = scan.nextInt();

				if (jumlah >= total) {
					if ("hp".equals(status)) {
						System.out.println("Berhasil dipesan");
						handphone.minusStock(qty);
						orders.add(new Order(id, handphone, qty));
						break;
					} else if ("vc".equals(status)) {
						System.out.println("Berhasil dipesan");
						voucher.minusStock(qty);
						orders.add(new Order(id, voucher, qty));
						break;
					}
				} else {
					System.out.println("Jumlah uang tidak mencukupi");
					break;
				}
			} while (true);
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
				case 0:
					break;
				default:
					System.out.println("Input invalid");
			}
		} while (choice != 0);

		System.out.println("Exiting program...");
	}
}
