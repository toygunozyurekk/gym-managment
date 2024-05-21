package controller;

import java.util.ArrayList;
import java.util.List;
import model.Calisan;
import util.DosyaIslemleri;

public class CalisanController {
    private static final String DOSYA_YOLU = "data/Calisanlar.txt";

    public static void calisanEkle(String ad, String soyad, String kullaniciAdi, String sifre, String pozisyon) {
        try {
            DosyaIslemleri.calisanEkle(DOSYA_YOLU, ad, soyad, kullaniciAdi, sifre, pozisyon);
            System.out.println("Çalışan başarıyla eklendi.");
        } catch (Exception e) {
            System.err.println("Çalışan eklenirken hata oluştu: " + e.getMessage());
        }
    }

    public static void calisanCikar(String kullaniciAdi) {
        try {
            DosyaIslemleri.calisanCikar(DOSYA_YOLU, kullaniciAdi);
            System.out.println("Çalışan başarıyla çıkarıldı.");
        } catch (Exception e) {
            System.err.println("Çalışan çıkarılırken hata oluştu: " + e.getMessage());
        }
    }

    public static List<Calisan> calisanlariOku() {
        List<String> veriler = DosyaIslemleri.veriOku(DOSYA_YOLU);
        List<Calisan> calisanlar = new ArrayList<>();
        for (String veri : veriler) {
            String[] bilgiler = veri.split(",");
            if (bilgiler.length == 5) {
                calisanlar.add(new Calisan(bilgiler[0], bilgiler[1], bilgiler[2], bilgiler[3], bilgiler[4]));
            } else {
                System.err.println("Geçersiz veri formatı: " + veri);
            }
        }
        return calisanlar;
    }

    public static boolean kullaniciDogrula(String kullaniciAdi, String sifre, String rol) {
        List<Calisan> calisanlar = calisanlariOku();
        for (Calisan calisan : calisanlar) {
            if (calisan.getKullaniciAdi().equals(kullaniciAdi) && calisan.getSifre().equals(sifre) && calisan.getPozisyon().equalsIgnoreCase(rol)) {
                return true;
            }
        }
        return false;
    }
}
