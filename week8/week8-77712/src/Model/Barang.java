package Model;

public class Barang {

	protected int stock;
	protected double harga;
	protected String id, nama;

	public Barang(String id, String nama, double harga, int stock) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
		this.stock = stock;
	}

	public Barang() {
	}

	public String getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public double getHarga() {
		return harga;
	}

	public int getStock() {
		return stock;
	}

	public void minusStock(int jumlah) {
		stock -= jumlah;
	}
}
