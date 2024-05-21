package model;

public class Urun {
    private String ad;
    private double fiyat;
    private int stok;

    public Urun(String ad, double fiyat, int stok) {
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
