package uas_praktik_oop_gl;

public class salma_RekamanKonser extends salma_Item {
    private String namaArtis;
    private String tanggalKonser;
    private String venue;
    private String linkRekaman;

    public salma_RekamanKonser(int itemId, String nama, float harga, int stok, String tanggalKonser, String venue,
            String linkRekaman) {
        super(itemId, nama, harga, stok);
        this.tanggalKonser = tanggalKonser;
        this.venue = venue;
        this.linkRekaman = linkRekaman;
    }

    public String getDataRekaman() {
        return "Tanggal Konser: " + tanggalKonser + "\nVenue: " + venue + "\nLink Rekaman: " + linkRekaman;
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

    public String getLinkRekaman() {
        return linkRekaman;
    }
}
