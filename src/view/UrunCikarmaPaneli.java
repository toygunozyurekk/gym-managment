package view;

import controller.UrunController;
import model.Urun;
import util.ComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UrunCikarmaPaneli extends JPanel {
    private JComboBox<String> urunComboBox;
    private JButton cikarButton;
    private JButton geriButton;
    private Image backgroundImage;

    public UrunCikarmaPaneli() {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        // Ürün listesi paneli
        JPanel urunListesiPanel = new JPanel();
        urunListesiPanel.setLayout(new GridLayout(2, 1));
        urunListesiPanel.setOpaque(false); // Arka planı saydam yap

        // Ürün combo box
        urunComboBox = new JComboBox<>();
        urunListesiniGuncelle();

        urunListesiPanel.add(ComponentFactory.createLabel("Çıkarılacak Ürünü Seçin:"));
        urunListesiPanel.add(urunComboBox);

        add(urunListesiPanel, BorderLayout.CENTER);

        // Buton paneli
        JPanel butonPanel = new JPanel();
        butonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        butonPanel.setOpaque(false); // Arka planı saydam yap

        cikarButton = ComponentFactory.createButton("Ürün Çıkar");
        cikarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenUrun = (String) urunComboBox.getSelectedItem();
                if (secilenUrun != null) {
                    UrunController.urunCikar(secilenUrun.split(" - ")[0]);
                    urunListesiniGuncelle();
                    JOptionPane.showMessageDialog(null, "Ürün başarıyla çıkarıldı!");
                }
            }
        });

        geriButton = ComponentFactory.createButton("Geri Dön");
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "AnaPanel");
            }
        });

        butonPanel.add(cikarButton);
        butonPanel.add(geriButton);

        add(butonPanel, BorderLayout.SOUTH);
    }

    public void urunListesiniGuncelle() {
        urunComboBox.removeAllItems();
        List<Urun> urunler = UrunController.urunleriOku();
        for (Urun urun : urunler) {
            urunComboBox.addItem(urun.getAd() + " - " + urun.getFiyat() + " TL - Stok: " + urun.getStok());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public JButton getGeriButton() {
        return geriButton;
    }
}
