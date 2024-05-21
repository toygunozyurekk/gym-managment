package view;

import controller.MusteriController;
import model.Musteri;
import util.ComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MusteriCikarmaPaneli extends JPanel {
    private final JComboBox<String> musteriComboBox;
    private final JButton cikarButton;
    private final JButton geriButton;
    private Image backgroundImage;

    public MusteriCikarmaPaneli() {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        // Müşteri listesi paneli
        JPanel musteriListesiPanel = new JPanel();
        musteriListesiPanel.setLayout(new GridLayout(2, 1));
        musteriListesiPanel.setOpaque(false); // Arka planı saydam yap

        // Müşteri combo box
        musteriComboBox = new JComboBox<>();
        musteriListesiniGuncelle();

        musteriListesiPanel.add(ComponentFactory.createLabel("Çıkarılacak Müşteriyi Seçin:"));
        musteriListesiPanel.add(musteriComboBox);

        add(musteriListesiPanel, BorderLayout.CENTER);

        // Buton paneli
        JPanel butonPanel = new JPanel();
        butonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        butonPanel.setOpaque(false); // Arka planı saydam yap

        cikarButton = ComponentFactory.createButton("Müşteri Çıkar");
        cikarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenMusteri = (String) musteriComboBox.getSelectedItem();
                if (secilenMusteri != null) {
                    MusteriController.musteriCikar(secilenMusteri.split(" - ")[1]);
                    musteriListesiniGuncelle();
                    JOptionPane.showMessageDialog(null, "Müşteri başarıyla çıkarıldı!");
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

    public void musteriListesiniGuncelle() {
        musteriComboBox.removeAllItems();
        List<Musteri> musteriler = MusteriController.musterileriOku();
        for (Musteri musteri : musteriler) {
            musteriComboBox.addItem(musteri.getAd() + " " + musteri.getSoyad() + " - " + musteri.getTelefon());
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
