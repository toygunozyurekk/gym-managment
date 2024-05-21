import controller.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.AylikButce;
import view.*;

public class Main extends JFrame {
    private final GirisPaneli girisPaneli;
    private final AnaPanel anaPanel;
    private final CalisanEklemePaneli calisanEklemePaneli;
    private final CalisanCikarmaPaneli calisanCikarmaPaneli;
    private final MusteriEklemePaneli musteriEklemePaneli;
    private final MusteriCikarmaPaneli musteriCikarmaPaneli;
    private final UrunEklemePaneli urunEklemePaneli;
    private final UrunCikarmaPaneli urunCikarmaPaneli;
    private final AylikButcePaneli aylikButcePaneli;
    private final MusteriOdemePaneli musteriOdemePaneli;
    private final DersSaatiAyarlamaPaneli dersSaatiAyarlamaPaneli;

    public Main() {
        setTitle("Gym Yönetim Sistemi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        urunCikarmaPaneli = new UrunCikarmaPaneli();
        urunEklemePaneli = new UrunEklemePaneli(urunCikarmaPaneli);
        musteriCikarmaPaneli = new MusteriCikarmaPaneli();
        musteriEklemePaneli = new MusteriEklemePaneli();
        calisanCikarmaPaneli = new CalisanCikarmaPaneli();
        calisanEklemePaneli = new CalisanEklemePaneli(calisanCikarmaPaneli);
        musteriOdemePaneli = new MusteriOdemePaneli();
        dersSaatiAyarlamaPaneli = new DersSaatiAyarlamaPaneli();
        girisPaneli = new GirisPaneli();
        anaPanel = new AnaPanel();
        aylikButcePaneli = new AylikButcePaneli(anaPanel);

        setLayout(new CardLayout());

        add(girisPaneli, "GirisPaneli");
        add(anaPanel, "AnaPanel");
        add(calisanEklemePaneli, "CalisanEklemePaneli");
        add(calisanCikarmaPaneli, "CalisanCikarmaPaneli");
        add(musteriEklemePaneli, "MusteriEklemePaneli");
        add(musteriCikarmaPaneli, "MusteriCikarmaPaneli");
        add(urunEklemePaneli, "UrunEklemePaneli");
        add(urunCikarmaPaneli, "UrunCikarmaPaneli");
        add(aylikButcePaneli, "AylikButcePaneli");
        add(musteriOdemePaneli, "MusteriOdemePaneli");
        add(dersSaatiAyarlamaPaneli, "DersSaatiAyarlamaPaneli");

        girisPaneli.setYoneticiGirisButtonListener(e -> {
            if (dogrulama("Yönetici")) {
                anaPanel.setRole("Yönetici");
                anaPanel.configureForRole("Yönetici");
                AylikButce aylikButce = AylikButceController.butceOku();
                if (aylikButce != null) {
                    anaPanel.setAylikButceLabel("Yıl: " + aylikButce.getYil() + ", Ay: " + aylikButce.getAy() + ", Bütçe: " + aylikButce.getButce());
                }
                showPanel("AnaPanel");
            }
        });

        girisPaneli.setAntrenorGirisButtonListener(e -> {
            if (dogrulama("Antrenör")) {
                anaPanel.setRole("Antrenör");
                anaPanel.configureForRole("Antrenör");
                AylikButce aylikButce = AylikButceController.butceOku();
                if (aylikButce != null) {
                    anaPanel.setAylikButceLabel("Yıl: " + aylikButce.getYil() + ", Ay: " + aylikButce.getAy() + ", Bütçe: " + aylikButce.getButce());
                }
                showPanel("AnaPanel");
            }
        });

        girisPaneli.setPersonelGirisButtonListener(e -> {
            if (dogrulama("Personel")) {
                anaPanel.setRole("Personel");
                anaPanel.configureForRole("Personel");
                AylikButce aylikButce = AylikButceController.butceOku();
                if (aylikButce != null) {
                    anaPanel.setAylikButceLabel("Yıl: " + aylikButce.getYil() + ", Ay: " + aylikButce.getAy() + ", Bütçe: " + aylikButce.getButce());
                }
                showPanel("AnaPanel");
            }
        });

        anaPanel.setUrunEkleButtonListener(e -> showPanel("UrunEklemePaneli"));
        anaPanel.setUrunCikarButtonListener(e -> {
            urunCikarmaPaneli.urunListesiniGuncelle();
            showPanel("UrunCikarmaPaneli");
        });
        anaPanel.setCalisanEkleButtonListener(e -> showPanel("CalisanEklemePaneli"));
        anaPanel.setCalisanCikarButtonListener(e -> {
            calisanCikarmaPaneli.calisanListesiniGuncelle();
            showPanel("CalisanCikarmaPaneli");
        });
        anaPanel.setMusteriEkleButtonListener(e -> showPanel("MusteriEklemePaneli"));
        anaPanel.setMusteriCikarButtonListener(e -> {
            musteriCikarmaPaneli.musteriListesiniGuncelle();
            showPanel("MusteriCikarmaPaneli");
        });
        anaPanel.setAylikButceButtonListener(e -> showPanel("AylikButcePaneli"));
        anaPanel.setMusteriOdemeButtonListener(e -> {
            List<String[]> odemeler = MusteriController.musteriOdemeleriniOku();
            musteriOdemePaneli.musteriOdemeleriniGuncelle(odemeler);
            showPanel("MusteriOdemePaneli");
        });
        anaPanel.setDersSaatiAyarlamaButtonListener(e -> {
            dersSaatiAyarlamaPaneli.musteriListesiniGuncelle();
            showPanel("DersSaatiAyarlamaPaneli");
        });
        anaPanel.setSignOutButtonListener(e -> showPanel("GirisPaneli"));

        calisanEklemePaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        calisanCikarmaPaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        musteriEklemePaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        musteriCikarmaPaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        urunEklemePaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        urunCikarmaPaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        aylikButcePaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        musteriOdemePaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
        dersSaatiAyarlamaPaneli.getGeriButton().addActionListener(e -> showPanel("AnaPanel"));
    }

    private boolean dogrulama(String rol) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField kullaniciAdiAlani = new JTextField(10);
        JPasswordField sifreAlani = new JPasswordField(10);

        panel.add(new JLabel("Kullanıcı Adı:"));
        panel.add(kullaniciAdiAlani);
        panel.add(new JLabel("Şifre:"));
        panel.add(sifreAlani);

        int secim = JOptionPane.showConfirmDialog(null, panel, rol + " Girişi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (secim == JOptionPane.OK_OPTION) {
            String kullaniciAdi = kullaniciAdiAlani.getText();
            String sifre = new String(sifreAlani.getPassword());
            if (CalisanController.kullaniciDogrula(kullaniciAdi, sifre, rol)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Yanlış Kullanıcı Adı veya Şifre!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}
