package model;

public class Calisan {
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String sifre;
    private String pozisyon;

    public Calisan(String ad, String soyad, String kullaniciAdi, String sifre, String pozisyon) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.pozisyon = pozisyon;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }
}
