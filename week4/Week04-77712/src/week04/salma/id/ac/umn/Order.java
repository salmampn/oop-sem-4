package week04.salma.id.ac.umn;

public class Order {
    private int id, jumlah, total;
    private Barang barang;
    public static int totalBelanja = 0;

    public Order() {
    }

    public Order(int id, int jumlah, Barang barang, int total) {
        this.id = id;
        this.jumlah = jumlah;
        this.barang = barang;
        this.total = total;
        totalBelanja += total;
    }

    public int getId() {
        return this.id;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public Barang getBarang() {
        return this.barang;
    }

    public int getTotal() {
        return this.total;
    }
}
