package uas_praktik_oop_gl;

public class salma_Merchandise extends salma_Item {
    private String namaMerk;
    private String kategori;

    public salma_Merchandise(int itemId, String nama, float harga, int stok, String namaMerk, String kategori) {
        super(itemId, nama, harga, stok);
        this.namaMerk = namaMerk;
        this.kategori = kategori;
    }

    public String getDataMerch() {
        return "Nama Merk: " + namaMerk + "\nKategori: " + kategori;
    }

    public String getNamaMerk() {
        return namaMerk;
    }

    public String getKategori() {
        return kategori;
    }
}
