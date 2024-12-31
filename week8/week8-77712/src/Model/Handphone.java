package Model;


public class Handphone extends Barang {

	private String warna;
	public static int total;
	
	public Handphone(String id, String nama, double harga, int stock, String warna) {
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
