package week06.salma.id.ac.umn;

public class Handphone extends Barang {

	private String warna;
	public static int total;

	public Handphone(int id, String nama, double harga, int stock, String warna) {
		super(id, nama, harga, stock);
		this.warna = warna;
	}

	public Handphone(String warna) {
		this.warna = warna;
	}

	public double getHarga() {
		return harga;
	}

	public String getWarna() {
		return warna;
	}

	public void minusStock(int qty) {
		stock -= qty;
	}
}
