package week03.salma.id.ac.umn;

public class PreludeString {
    public static void main(String[] args) {
        // Membuat sebuah string
        String pbo1 = "Pemrograman Berorientasi Objek";
        String pbo2 = new String("Pemrograman Berorientasi Objek");

        // String Method
        pbo1.length(); // 30
        pbo1.charAt(12); // Berorientasi Objek
        pbo1.substring(24); // Objek
        pbo1.substring(12, 24); // Berorientasi

        String kode = "IF402 - ";
        String out = kode.concat(pbo1);
        // IF402 - Pemrograman Berorientasi Objek
    }
}
