package uas_praktik_oop_gl;

public class salma_Item {
    private int itemId;
    private String nama;
    private float harga;
    private int stok;

    public salma_Item() {

    }

    public salma_Item(int itemId, String nama, float harga, int stok) {
        this.itemId = itemId;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public int getItemId() {
        return itemId;
    }

    public String getNama() {
        return nama;
    }

    public float getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
    }

    public void kurangiStok(int jumlah) {
        stok = stok - jumlah;
    }

}
