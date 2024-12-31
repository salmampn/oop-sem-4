package uas_praktik_oop_gl;

public class salma_TiketKonser extends salma_Item {
    private String namaArtis;
    private String tanggalKonser;
    private String venue;

    public salma_TiketKonser(int itemId, String nama, float harga, int stok, String namaArtis, String tanggalKonser,
            String venue) {
        super(itemId, nama, harga, stok);
        this.namaArtis = namaArtis;
        this.tanggalKonser = tanggalKonser;
        this.venue = venue;
    }

    public String getDataTiket() {
        return "Nama Artis: " + namaArtis + "\nTanggal Konser: " + tanggalKonser
                + "\nVenue: " + venue;
    }

    public int hitungJarakTanggalDenganHariIni() {
        return 0;
    }

    public String getNamaArtis() {
        return namaArtis;
    }

    public String getTanggalKonser() {
        return tanggalKonser;
    }

    public String getVenue() {
        return venue;
    }
}
