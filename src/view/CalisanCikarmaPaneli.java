package view;

import controller.CalisanController;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Calisan;

public class CalisanCikarmaPaneli extends JPanel {
    private final JComboBox<String> calisanComboBox;
    private final JButton cikarButton;
    private final JButton geriButton;
    private Image backgroundImage;

    public CalisanCikarmaPaneli() {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel calisanLabel = createLabel("Çıkarılacak Çalışan:");
        calisanComboBox = new JComboBox<>();
        cikarButton = createButton("Çıkar");
        geriButton = createButton("Geri");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(calisanLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(calisanComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(cikarButton, gbc);

        gbc.gridy = 2;
        add(geriButton, gbc);

        cikarButton.addActionListener(e -> {
            String secilenCalisan = (String) calisanComboBox.getSelectedItem();
            if (secilenCalisan != null) {
                CalisanController.calisanCikar(secilenCalisan.split(" ")[2]); // Kullanıcı adını al
                calisanListesiniGuncelle();
                calisanComboBox.revalidate();
                calisanComboBox.repaint();
                JOptionPane.showMessageDialog(null, "Çalışan çıkarıldı!");
            }
        });

        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel");
        });

        calisanListesiniGuncelle();
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE); // Yazı rengini beyaz yap
        label.setFont(new Font("Arial", Font.BOLD, 12)); // Yazı tipini bold yap ve boyutunu ayarla
        return label;
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

    public void calisanListesiniGuncelle() {
        calisanComboBox.removeAllItems();
        List<Calisan> calisanlar = CalisanController.calisanlariOku();
        for (Calisan calisan : calisanlar) {
            calisanComboBox.addItem(calisan.getAd() + " " + calisan.getSoyad() + " " + calisan.getKullaniciAdi());
        }
    }

    public JButton getGeriButton() {
        return geriButton;
    }
}
