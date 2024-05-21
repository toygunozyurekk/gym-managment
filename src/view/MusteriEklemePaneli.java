package view;

import controller.MusteriController;
import java.awt.*;
import javax.swing.*;
import util.ComponentFactory;

public class MusteriEklemePaneli extends JPanel {
    private final JTextField adField;
    private final JTextField soyadField;
    private final JTextField telefonField;
    private final JTextField yilField;
    private final JTextField ayField;
    private final JTextField odemeField;
    private final JButton ekleButton;
    private final JButton geriButton;
    private Image backgroundImage;

    public MusteriEklemePaneli() {
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel adLabel = ComponentFactory.createLabel("Ad:");
        adField = ComponentFactory.createTextField();
        JLabel soyadLabel = ComponentFactory.createLabel("Soyad:");
        soyadField = ComponentFactory.createTextField();
        JLabel telefonLabel = ComponentFactory.createLabel("Telefon:");
        telefonField = ComponentFactory.createTextField();
        JLabel yilLabel = ComponentFactory.createLabel("Yıl:");
        yilField = ComponentFactory.createTextField();
        JLabel ayLabel = ComponentFactory.createLabel("Ay:");
        ayField = ComponentFactory.createTextField();
        JLabel odemeLabel = ComponentFactory.createLabel("Ödeme:");
        odemeField = ComponentFactory.createTextField();

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
        add(soyadLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(soyadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(telefonLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(telefonField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(yilLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(yilField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(ayLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(ayField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(odemeLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(odemeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(ekleButton, gbc);

        gbc.gridy = 7;
        add(geriButton, gbc);

        ekleButton.addActionListener(e -> {
            String ad = adField.getText();
            String soyad = soyadField.getText();
            String telefon = telefonField.getText();
            String yil = yilField.getText();
            String ay = ayField.getText();
            double odeme;
            try {
                odeme = Double.parseDouble(odemeField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Geçerli bir ödeme girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MusteriController.musteriEkle(ad, soyad, telefon, yil, ay, odeme);
            JOptionPane.showMessageDialog(null, "Müşteri eklendi ve ödeme bilgisi kaydedildi!");
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public JTextField getAdField() {
        return adField;
    }

    public JTextField getSoyadField() {
        return soyadField;
    }

    public JTextField getTelefonField() {
        return telefonField;
    }

    public JTextField getYilField() {
        return yilField;
    }

    public JTextField getAyField() {
        return ayField;
    }

    public JTextField getOdemeField() {
        return odemeField;
    }

    public JButton getEkleButton() {
        return ekleButton;
    }

    public JButton getGeriButton() {
        return geriButton;
    }
}
