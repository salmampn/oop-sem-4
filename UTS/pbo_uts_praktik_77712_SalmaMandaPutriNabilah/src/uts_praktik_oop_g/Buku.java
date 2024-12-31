package uts_praktik_oop_g;

public class Buku extends Publikasi {
    private String penerbit;
    private int jumlahHalaman;

    public Buku(String judul, String penulis, int tahunTerbit, String kategori, String penerbit,
            int jumlahHalaman) {
        super(judul, penulis, kategori, tahunTerbit);
        this.penerbit = penerbit;
        this.jumlahHalaman = jumlahHalaman;
    }

    public Buku() {
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }
}
