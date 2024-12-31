package Tugas;

public class Aktor extends MediaPromosi {
    private int umur;
    private int tinggiBadan;
    private int beratBadan;
    private int fans;
    private String fanClub;

    public Aktor() {
    }

    public Aktor(String nama, int harga, int umur, int tinggiBadan, int beratBadan, int fans, String fanClub) {
        super(nama, harga);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.fans = fans;
        this.fanClub = fanClub;
    }

    public int getUmur() {
        return umur;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public int getFans() {
        return fans;
    }

    public String getFanClub() {
        return fanClub;
    }
}
