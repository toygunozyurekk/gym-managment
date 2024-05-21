package view;

import controller.AylikButceController;
import java.awt.*;
import javax.swing.*;

public class AylikButcePaneli extends JPanel {
    private final JTextField yilField;
    private final JTextField ayField;
    private final JTextField butceField;
    private final JButton kaydetButton;
    private final JButton geriButton;
    private final AnaPanel anaPanel;
    private Image backgroundImage;

    public AylikButcePaneli(AnaPanel anaPanel) {
        this.anaPanel = anaPanel;

        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel yilLabel = createLabel("Yıl:");
        yilField = createTextField();
        JLabel ayLabel = createLabel("Ay:");
        ayField = createTextField();
        JLabel butceLabel = createLabel("Bütçe:");
        butceField = createTextField();

        kaydetButton = createButton("Kaydet");
        geriButton = createButton("Geri");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(yilLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(yilField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(ayLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(ayField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(butceLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(butceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(kaydetButton, gbc);

        gbc.gridy = 4;
        add(geriButton, gbc);

        kaydetButton.addActionListener(e -> {
            String yil = yilField.getText();
            String ay = ayField.getText();
            double butce;
            try {
                butce = Double.parseDouble(butceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Geçerli bir bütçe girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AylikButceController.butceKaydet(yil, ay, butce);
            JOptionPane.showMessageDialog(null, "Bütçe Kaydedildi!");

            // AnaPanel'deki bütçe etiketini güncelle
            if (anaPanel != null) {
                anaPanel.setAylikButceLabel("Yıl: " + yil + ", Ay: " + ay + ", Bütçe: " + butce);
            }
        });

        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel");
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

    public JTextField getYilField() {
        return yilField;
    }

    public JTextField getAyField() {
        return ayField;
    }

    public JTextField getButceField() {
        return butceField;
    }

    public JButton getKaydetButton() {
        return kaydetButton;
    }

    public JButton getGeriButton() {
        return geriButton;
    }
}
