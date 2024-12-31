package Tugas;

public class Magang extends Karyawan {
    public Magang() {
    };

    public Magang(String id, String nama, int gaji) {
        super(id, nama, gaji);
    }

    public int getGaji() {
        return gaji;
    }
}
