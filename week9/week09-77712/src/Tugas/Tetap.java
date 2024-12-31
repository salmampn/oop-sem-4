package Tugas;

public class Tetap extends Karyawan {
    public Tetap() {
    };

    public Tetap(String id, String nama, int gaji) {
        super(id, nama, gaji);
    }

    public int getGaji() {
        return gaji;
    }
}
