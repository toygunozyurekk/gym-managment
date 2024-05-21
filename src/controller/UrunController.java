package controller;

import java.util.ArrayList;
import java.util.List;
import model.Urun;
import util.DosyaIslemleri;

public class UrunController {
    public static void urunEkle(String ad, double fiyat, int stok) {
        Urun urun = new Urun(ad, fiyat, stok);
        String veri = urun.getAd() + "," + urun.getFiyat() + "," + urun.getStok();
        DosyaIslemleri.veriYaz("data/Urunler.txt", veri);
    }

    public static void urunCikar(String ad) {
        List<String> urunler = DosyaIslemleri.veriOku("data/Urunler.txt");
        List<String> guncelUrunler = new ArrayList<>();
        for (String urun : urunler) {
            String[] urunBilgileri = urun.split(",");
            if (!urunBilgileri[0].equals(ad)) {
                guncelUrunler.add(urun);
            }
        }
        DosyaIslemleri.dosyaYaz("data/Urunler.txt", guncelUrunler);
    }

    public static List<Urun> urunleriOku() {
        List<String> veriler = DosyaIslemleri.veriOku("data/Urunler.txt");
        List<Urun> urunler = new ArrayList<>();
        for (String veri : veriler) {
            String[] bilgiler = veri.split(",");
            if (bilgiler.length == 3) {
                try {
                    urunler.add(new Urun(bilgiler[0], Double.parseDouble(bilgiler[1]), Integer.parseInt(bilgiler[2])));
                } catch (NumberFormatException e) {
                    System.err.println("Geçersiz veri formatı: " + veri);
                }
            } else {
                System.err.println("Geçersiz veri formatı: " + veri);
            }
        }
        return urunler;
    }
}
