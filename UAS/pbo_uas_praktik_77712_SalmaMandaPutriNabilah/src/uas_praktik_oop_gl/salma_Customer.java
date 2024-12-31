package uas_praktik_oop_gl;

public class salma_Customer {
    private int customerId;
    private String nama;
    private String email;
    private String noHp;

    public salma_Customer(int customerId, String nama, String email, String noHp) {
        this.customerId = customerId;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getNama() {
        return nama;

    }

    public String getDetailPelanggan() {
        return "Nama: " + nama + "\nEmail: " + email + "\nNo HP: " + noHp;
    }
}
