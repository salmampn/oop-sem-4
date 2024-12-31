package Tugas;

public class Celebgram extends MediaPromosi {
    private int umur;
    private int tinggiBadan;
    private int beratBadan;
    private int followers;
    private String akunMedia;
    private String bidang;

    public Celebgram() {
    }

    public Celebgram(String nama, int harga, int umur, int tinggiBadan, int beratBadan, int followers, String akunMedia,
            String bidang) {
        super(nama, harga);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.followers = followers;
        this.akunMedia = akunMedia;
        this.bidang = bidang;
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

    public int getFollowers() {
        return followers;
    }

    public String getAkunMedia() {
        return akunMedia;
    }

    public String getBidang() {
        return bidang;
    }
}
