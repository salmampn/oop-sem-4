package week07.salma.id.ac.umn;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static ArrayList<Item> items = new ArrayList<>();
	static ArrayList<Payment> payments = new ArrayList<>();
	static Scanner s = new Scanner(System.in);
	static String choose, status;

	public static void seedData() {
		items.add(new Item("Kulkas", "Electronic", 4800000));
		items.add(new Item("TV", "Electronic", 1280000));
		items.add(new Item("Laptop", "Computer", 6000000));
		items.add(new Item("PC", "Computer", 12000000));
	}

	public static void printItem(Item item) {
		System.out.println("Nama  : " + item.getName());
		System.out.println("Tipe  : " + item.getType());
		System.out.println("Harga : " + item.getPrice());
	}

	public static void cashPayment(Item item) {
		int pay;
		System.out.print("Bayar (Y/N) : ");
		choose = s.next();
		Cash cash = new Cash(item);
		if ("Y".equals(choose)) {
			System.out.println("Harga Pembayaran : " + item.getPrice());
			System.out.print("Bayar : ");
			pay = s.nextInt();

			if (pay >= item.getPrice()) {
				cash.pay();
				System.out.println("Transaksi telah dibayar lunas");
				payments.add(cash);
			} else {
				System.out.println("Uang tidak mencukupi");
			}
		} else {
			System.out.println("Transaksi telah disimpan");
			payments.add(cash);
		}
	}

	public static void creditPayment(Item item) {
		int cicil = 0, pay;
		do {
			System.out.print("Lama Cicilan (3/6/9/12) : ");
			cicil = s.nextInt();
		} while (cicil != 3 && cicil != 6 && cicil != 9 && cicil != 12);

		System.out.println("Harga Pembayaran : " + item.getPrice() / cicil);
		do {
			System.out.print("Bayar : ");
			pay = s.nextInt();
		} while (pay < item.getPrice() / cicil);

		if (pay >= item.getPrice() / cicil) {
			Credit credit = new Credit(item, cicil);
			credit.installment++;
			credit.pay();

			System.out.println("Transaksi telah dibayar");

			payments.add(credit);
		}
	}

	public static void pesan() {
		int id = 0, choice;
		System.out.println("---Daftar Barang---");
		for (int i = 0; i < items.size(); i++) {
			System.out.println("No : " + (i + 1));
			printItem(items.get(i));
			System.out.println("------------------------------");
		}
		System.out.print("Pilih : ");
		id = s.nextInt();

		printItem(items.get(id - 1));

		System.out.println("---Tipe Pembayaran---");
		System.out.println("1. Cash\n2. Credit");
		System.out.print("Pilih : ");
		choice = s.nextInt();

		if (choice == 1) {
			cashPayment(items.get(id - 1));
		}

		if (choice == 2) {
			creditPayment(items.get(id - 1));
		}
	}

	public static void show() {
		Payment selectedTransaksi;
		Credit selectedCredit;
		Cash selectedCash;
		int counter = 0, pay;

		if (payments.isEmpty()) {
			System.out.println("Tidak ada transaksi");
		} else {
			for (Payment payment : payments) {
				counter++;
				System.out.println("No              : " + counter);
				System.out.println("Nama            : " + payment.item.getName());
				System.out.println("Tipe            : " + payment.item.getType());
				System.out.println("Tipe            : " + payment.getStatus());
				System.out.println("Sisa Pembayaran : " + payment.getRemainingAmount());
				System.out.println("--------------------");
			}
			System.out.print("Pilih No Transaksi : ");
			int menu = s.nextInt();

			if (menu > payments.size() || menu <= 0) {
				System.out.println("Input Invalid");
			} else {
				selectedTransaksi = payments.get(menu - 1);

				if (selectedTransaksi instanceof Credit) {
					selectedCredit = (Credit) selectedTransaksi;
					System.out.println("Nama             : " + selectedTransaksi.item.getName());
					System.out.println("Tipe             : " + selectedTransaksi.item.getType());
					System.out.println("Status           : " + selectedTransaksi.getStatus());
					System.out.println("Sisa Pembayaran  : " + selectedTransaksi.getRemainingAmount());
					System.out.println("Harga Pembayaran : " + selectedCredit.pay());
					if (!selectedTransaksi.getPaidOff()) {
						do {
							System.out.print("Bayar : ");
							pay = s.nextInt();
							if (pay >= selectedCredit.pay()) {
								selectedCredit.installment++;
								System.out.println("Transaksi telah dibayar");
							}
						} while (pay < selectedCredit.pay());
					}
				} else {
					selectedCash = (Cash) selectedTransaksi;
					System.out.println("Nama             : " + selectedTransaksi.item.getName());
					System.out.println("Tipe             : " + selectedTransaksi.item.getType());
					System.out.println("Status           : " + selectedTransaksi.getStatus());
					System.out.println("Sisa Pembayaran  : " + selectedTransaksi.getRemainingAmount());
					System.out.println("Harga Pembayaran : " + selectedCash.getRemainingAmount());
					if (!selectedTransaksi.getPaidOff()) {
						do {
							System.out.print("Bayar : ");
							pay = s.nextInt();
							if (pay >= selectedCash.item.getPrice()) {
								selectedCash.pay();
							}
						} while (pay < selectedCash.item.getPrice());
					}
					System.out.println("Transaksi telah dibayar lunas");
				}
			}
		}
	}

	public static void main(String[] args) {
		int opt = 0;

		seedData();

		do {
			System.out.println("---Program Toko Elektronik---");
			System.out.println("1. Pesan Barang\n2. Lihat Pesanan\n0. Keluar");
			System.out.print("Pilihan : ");
			opt = s.nextInt();

			if (opt == 1) {
				pesan();
			} else if (opt == 2) {
				show();
			} else {
				System.out.println("Input Invalid");
			}
		} while (opt != 0);

	}

}
