package controller;

import java.util.List;
import model.AylikButce;
import util.DosyaIslemleri;

public class AylikButceController {
    public static void butceKaydet(String yil, String ay, double butce) {
        AylikButce aylikButce = new AylikButce(yil, ay, butce);
        DosyaIslemleri.veriYaz("data/aylik_butce.txt", aylikButce.toString());
    }

    public static AylikButce butceOku() {
        List<String> butceList = DosyaIslemleri.veriOku("data/aylik_butce.txt");
        if (!butceList.isEmpty()) {
            String[] butceBilgileri = butceList.get(butceList.size() - 1).split(",");
            if (butceBilgileri.length == 3) {
                try {
                    return new AylikButce(butceBilgileri[0], butceBilgileri[1], Double.parseDouble(butceBilgileri[2]));
                } catch (NumberFormatException e) {
                    System.err.println("Geçersiz veri formatı: " + butceList.get(butceList.size() - 1));
                }
            } else {
                System.err.println("Geçersiz veri formatı: " + butceList.get(butceList.size() - 1));
            }
        }
        return null;
    }

    public static double getKalanButce() {
        AylikButce aylikButce = butceOku();
        if (aylikButce != null) {
            return aylikButce.getButce();
        }
        return 0;
    }

    public static void harcamaYap(double miktar) {
        AylikButce aylikButce = butceOku();
        if (aylikButce != null) {
            if (miktar <= aylikButce.getButce()) {
                aylikButce.setButce(aylikButce.getButce() - miktar);
                butceKaydet(aylikButce.getYil(), aylikButce.getAy(), aylikButce.getButce());
            } else {
                System.err.println("Yetersiz bütçe.");
            }
        } else {
            System.err.println("Bütçe bilgisi bulunamadı.");
        }
    }
}
