package Model;


public class Voucher extends Barang {
	
	private double pajak, hargaJual;
	public static int total;
	
	public Voucher(String id, String nama, double harga, int stock, double pajak) {
		super(id, nama, harga, stock);
		this.pajak = pajak;
	}
	
	public double getPajak() {
		return pajak;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public double getHargaJual() {
		hargaJual = harga + (harga * pajak);
		
		return hargaJual;
	}
	
	public void minusStock(int qty) {
		stock -= qty;
	}
}
