package uts_praktik_oop_g;

public class Order {
    private Publikasi namaPublikasi;
    private String namaPeminjam;
    private String tanggalMulai;
    private String tanggalSelesai;
    private String status;
    private String id;

    public Order(Publikasi namaPublikasi, String namaPeminjam, String tanggalMulai,
            String tanggalSelesai, String status) {
        this.namaPublikasi = namaPublikasi;
        this.namaPeminjam = namaPeminjam;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.status = status;
    }

    public void mulaiPeminjaman() {
        this.status = "Dipinjam";
    }

    public void melebihiTenggat() {
        this.status = "Melebihi Tenggat";
    }

    public void kembalikanBuku() {
        this.status = "Dikembalikan";
    }

    public Publikasi getNamaPublikasi() {
        return namaPublikasi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public String getStatus() {
        return status;
    }

    public String getID() {
        return id;
    }
}
