package uts_praktik_oop_g;

public class Publikasi {
    private String judul;
    private String penulis;
    private String kategori;
    private int tahunTerbit;

    public Publikasi(String judul, String penulis, String kategori, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.tahunTerbit = tahunTerbit;
    }

    public Publikasi() {
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }
}
