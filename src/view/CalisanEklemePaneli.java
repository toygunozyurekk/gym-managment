package view;

import controller.CalisanController;
import java.awt.*;
import javax.swing.*;

public class CalisanEklemePaneli extends JPanel {
    private final JTextField adField;
    private final JTextField soyadField;
    private final JTextField kullaniciAdiField;
    private final JTextField sifreField;
    private final JComboBox<String> pozisyonBox;
    private final JButton ekleButton;
    private final JButton geriButton;
    private final CalisanCikarmaPaneli calisanCikarmaPaneli;
    private Image backgroundImage;

    public CalisanEklemePaneli(CalisanCikarmaPaneli calisanCikarmaPaneli) {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.calisanCikarmaPaneli = calisanCikarmaPaneli;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel adLabel = createLabel("Ad:");
        adField = createTextField();
        JLabel soyadLabel = createLabel("Soyad:");
        soyadField = createTextField();
        JLabel kullaniciAdiLabel = createLabel("Kullanıcı Adı:");
        kullaniciAdiField = createTextField();
        JLabel sifreLabel = createLabel("Şifre:");
        sifreField = createTextField();
        JLabel pozisyonLabel = createLabel("Pozisyon:");
        pozisyonBox = new JComboBox<>(new String[]{"Yönetici", "Antrenör", "Personel"});

        ekleButton = createButton("Ekle");
        geriButton = createButton("Geri");

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
        add(soyadLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(soyadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(kullaniciAdiLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(kullaniciAdiField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(sifreLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(sifreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(pozisyonLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(pozisyonBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(ekleButton, gbc);

        gbc.gridy = 6;
        add(geriButton, gbc);

        ekleButton.addActionListener(e -> {
            String ad = adField.getText();
            String soyad = soyadField.getText();
            String kullaniciAdi = kullaniciAdiField.getText();
            String sifre = sifreField.getText();
            String pozisyon = (String) pozisyonBox.getSelectedItem();
            CalisanController.calisanEkle(ad, soyad, kullaniciAdi, sifre, pozisyon);
            JOptionPane.showMessageDialog(null, "Çalışan eklendi!");
            calisanCikarmaPaneli.calisanListesiniGuncelle();
        });

        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel"); // Geri dönüş yapacağınız panel ismi "AnaPanel" olmalıdır.
        });
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
