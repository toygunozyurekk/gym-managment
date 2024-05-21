package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DosyaIslemleri {
    private static final Logger LOGGER = Logger.getLogger(DosyaIslemleri.class.getName());

    public static List<String> veriOku(String dosyaYolu) {
        List<String> veriler = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                veriler.add(satir);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Veri okuma sırasında hata oluştu: " + dosyaYolu, e);
        }
        return veriler;
    }

    public static void veriYaz(String dosyaYolu, String veri) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu, true))) {
            writer.write(veri);
            writer.newLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Veri yazma sırasında hata oluştu: " + dosyaYolu, e);
        }
    }

    public static void dosyaYaz(String dosyaYolu, List<String> veriler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu))) {
            for (String veri : veriler) {
                writer.write(veri);
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Dosya yazma sırasında hata oluştu: " + dosyaYolu, e);
        }
    }

    public static void calisanEkle(String dosyaYolu, String ad, String soyad, String kullaniciAdi, String sifre, String pozisyon) {
        String veri = ad + "," + soyad + "," + kullaniciAdi + "," + sifre + "," + pozisyon;
        veriYaz(dosyaYolu, veri);
    }

    public static void calisanCikar(String dosyaYolu, String kullaniciAdi) {
        List<String> calisanlar = veriOku(dosyaYolu);
        List<String> guncelCalisanlar = new ArrayList<>();
        for (String calisan : calisanlar) {
            String[] bilgiler = calisan.split(",");
            if (!bilgiler[2].equals(kullaniciAdi)) { // 2. indeks kullaniciAdi
                guncelCalisanlar.add(calisan);
            }
        }
        dosyaYaz(dosyaYolu, guncelCalisanlar);
    }

    public static void dersSaatiEkle(String dosyaYolu, String musteri, String dersSaati, String dersGunu) {
        String veri = musteri + "," + dersSaati + "," + dersGunu;
        veriYaz(dosyaYolu, veri);
    }
}
