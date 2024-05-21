package model;

public class Musteri {
    private String ad;
    private String soyad;
    private String telefon;
    private String yil;
    private String ay;
    private double odeme;

    public Musteri(String ad, String soyad, String telefon, String yil, String ay, double odeme) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.yil = yil;
        this.ay = ay;
        this.odeme = odeme;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getYil() {
        return yil;
    }

    public String getAy() {
        return ay;
    }

    public double getOdeme() {
        return odeme;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public void setOdeme(double odeme) {
        this.odeme = odeme;
    }
}
