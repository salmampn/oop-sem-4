package uts_praktik_oop_g;

public class Artikel extends Publikasi {
    private String universitas;
    private int halaman;
    private int volume;

    public Artikel(String judul, String penulis, int tahunTerbit, String kategori, String universitas,
            int halaman, int volume) {
        super(judul, penulis, kategori, tahunTerbit);
        this.universitas = universitas;
        this.halaman = halaman;
        this.volume = volume;
    }

    public Artikel() {
    }

    public String getUniversitas() {
        return universitas;
    }

    public int getHalaman() {
        return halaman;
    }

    public int getVolume() {
        return volume;
    }
}
