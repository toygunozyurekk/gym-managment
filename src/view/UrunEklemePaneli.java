package view;

import controller.UrunController;
import java.awt.*;
import javax.swing.*;
import util.ComponentFactory;

public class UrunEklemePaneli extends JPanel {
    private final JTextField adField;
    private final JTextField fiyatField;
    private final JTextField stokField;
    private final JButton ekleButton;
    private final JButton geriButton;
    private final UrunCikarmaPaneli urunCikarmaPaneli;
    private Image backgroundImage;

    public UrunEklemePaneli(UrunCikarmaPaneli urunCikarmaPaneli) {
        this.urunCikarmaPaneli = urunCikarmaPaneli;

        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel adLabel = ComponentFactory.createLabel("Ürün Adı:");
        adField = ComponentFactory.createTextField();
        JLabel fiyatLabel = ComponentFactory.createLabel("Fiyat:");
        fiyatField = ComponentFactory.createTextField();
        JLabel stokLabel = ComponentFactory.createLabel("Stok:");
        stokField = ComponentFactory.createTextField();

        ekleButton = ComponentFactory.createButton("Ekle");
        geriButton = ComponentFactory.createButton("Geri");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(adLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(adField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(fiyatLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(fiyatField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(stokLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(stokField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(ekleButton, gbc);

        gbc.gridy = 4;
        add(geriButton, gbc);

        ekleButton.addActionListener(e -> {
            String ad = adField.getText();
            double fiyat;
            int stok;
            try {
                fiyat = Double.parseDouble(fiyatField.getText());
                stok = Integer.parseInt(stokField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Geçerli bir fiyat ve stok girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            UrunController.urunEkle(ad, fiyat, stok);
            JOptionPane.showMessageDialog(null, "Ürün eklendi!");
            urunCikarmaPaneli.urunListesiniGuncelle(); // Ürün listesi güncelleniyor
        });

        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel");
        });
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
