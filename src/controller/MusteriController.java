package controller;

import java.util.ArrayList;
import java.util.List;
import model.Musteri;
import util.DosyaIslemleri;

public class MusteriController {
    private static final String DOSYA_YOLU = "data/MusteriOdemeleri.txt";

    public static void musteriEkle(String ad, String soyad, String telefon, String yil, String ay, double odeme) {
        DosyaIslemleri.veriYaz(DOSYA_YOLU, ad + "," + soyad + "," + telefon + "," + yil + "," + ay + "," + odeme);
    }

    public static void musteriCikar(String telefon) {
        List<String> musteriler = DosyaIslemleri.veriOku(DOSYA_YOLU);
        List<String> guncelMusteriler = new ArrayList<>();
        for (String musteri : musteriler) {
            String[] musteriBilgileri = musteri.split(",");
            if (!musteriBilgileri[2].equals(telefon)) {
                guncelMusteriler.add(musteri);
            }
        }
        DosyaIslemleri.dosyaYaz(DOSYA_YOLU, guncelMusteriler);
    }

    public static List<Musteri> musterileriOku() {
        List<String> veriler = DosyaIslemleri.veriOku(DOSYA_YOLU);
        List<Musteri> musteriler = new ArrayList<>();
        for (String veri : veriler) {
            String[] bilgiler = veri.split(",");
            if (bilgiler.length == 6) {
                try {
                    musteriler.add(new Musteri(bilgiler[0], bilgiler[1], bilgiler[2], bilgiler[3], bilgiler[4], Double.parseDouble(bilgiler[5])));
                } catch (NumberFormatException e) {
                    System.err.println("Geçersiz veri formatı: " + veri);
                }
            } else {
                System.err.println("Geçersiz veri formatı: " + veri);
            }
        }
        return musteriler;
    }

    public static List<String[]> musteriOdemeleriniOku() {
        List<String> veriler = DosyaIslemleri.veriOku(DOSYA_YOLU);
        List<String[]> odemeler = new ArrayList<>();
        for (String veri : veriler) {
            String[] bilgiler = veri.split(",");
            if (bilgiler.length == 6) {
                odemeler.add(bilgiler);
            } else {
                System.err.println("Geçersiz veri formatı: " + veri);
            }
        }
        return odemeler;
    }
}
