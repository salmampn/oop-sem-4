package Tugas;

public class Karyawan {
    protected String id;
    protected String nama;
    protected int gaji;

    public Karyawan() {
    };

    public Karyawan(String id, String nama, int gaji) {
        this.id = id;
        this.nama = nama;
        this.gaji = gaji;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getGaji() {
        return gaji;
    }
}
