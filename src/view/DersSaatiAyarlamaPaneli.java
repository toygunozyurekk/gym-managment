package view;

import controller.MusteriController;
import util.DosyaIslemleri;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import model.Musteri;

public class DersSaatiAyarlamaPaneli extends JPanel {
    private final JComboBox<String> musteriComboBox;
    private final JTextField dersSaatiField;
    private final JTextField dersGunuField;
    private final JButton kaydetButton;
    private final JButton geriButton;
    private static final String DOSYA_YOLU = "data/DersSaatleri.txt";
    private Image backgroundImage;

    public DersSaatiAyarlamaPaneli() {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel musteriLabel = createLabel("Müşteri:");
        musteriComboBox = new JComboBox<>();
        JLabel dersSaatiLabel = createLabel("Ders Saati:");
        dersSaatiField = createTextField();
        JLabel dersGunuLabel = createLabel("Ders Günü:");
        dersGunuField = createTextField();

        kaydetButton = createButton("Kaydet");
        geriButton = createButton("Geri");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(musteriLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(musteriComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(dersSaatiLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(dersSaatiField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(dersGunuLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(dersGunuField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(kaydetButton, gbc);

        gbc.gridy = 4;
        add(geriButton, gbc);

        kaydetButton.addActionListener(e -> {
            String musteri = (String) musteriComboBox.getSelectedItem();
            String dersSaati = dersSaatiField.getText();
            String dersGunu = dersGunuField.getText();
            if (musteri != null && !dersSaati.isEmpty() && !dersGunu.isEmpty()) {
                DosyaIslemleri.dersSaatiEkle(DOSYA_YOLU, musteri, dersSaati, dersGunu);
                JOptionPane.showMessageDialog(null, "Ders saati ve günü kaydedildi!");
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel");
        });

        musteriListesiniGuncelle();
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE); // Yazı rengini beyaz yap
        label.setFont(new Font("Arial", Font.BOLD, 12)); // Yazı tipini bold yap ve boyutunu ayarla
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(15);
        textField.setForeground(Color.BLACK); // Yazı rengini siyah yap
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 30)); // Buton boyutunu ayarla
        button.setForeground(Color.BLACK); // Yazı rengini siyah yap
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Yazı tipini bold yap ve boyutunu ayarla
        return button;
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
