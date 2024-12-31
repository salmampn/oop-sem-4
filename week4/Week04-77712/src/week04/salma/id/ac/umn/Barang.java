package week04.salma.id.ac.umn;

public class Barang {
    private int id, stock, harga;
    private String nama;

    public Barang() {
    } // Constructor (default constructor

    public Barang(int id, int stock, int harga, String nama) {
        this.id = id;
        this.stock = stock;
        this.harga = harga;
        this.nama = nama;
    }

    public int getId() {
        return this.id;
    }

    public int getStock() {
        return this.stock;
    }

    public int getHarga() {
        return this.harga;
    }

    public String getNama() {
        return this.nama;
    }

    public void minusStock(int qty) {
        this.stock -= qty;
    }
}
