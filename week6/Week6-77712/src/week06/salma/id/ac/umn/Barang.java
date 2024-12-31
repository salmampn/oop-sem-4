package week06.salma.id.ac.umn;

public class Barang {

	protected int id, stock;
	protected double harga;
	protected String nama;

	public Barang(int id, String nama, double harga, int stock) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
		this.stock = stock;
	}

	public Barang() {
	}

	public int getId() {
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

	// public void minusStock(int jumlah) {
	// stock -= jumlah;
	// }
}
