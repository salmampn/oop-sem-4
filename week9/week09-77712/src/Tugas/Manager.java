package Tugas;

public class Manager extends Karyawan {
    public Manager() {
    };

    public Manager(String id, String nama, int gaji) {
        super(id, nama, gaji);
    }

    public void getGaji(int gaji) {
        this.gaji = gaji;
    }
}
