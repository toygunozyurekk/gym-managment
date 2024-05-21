package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GirisPaneli extends JPanel {
    private JButton yoneticiGirisButton;
    private JButton antrenorGirisButton;
    private JButton personelGirisButton;
    private Image backgroundImage;

    public GirisPaneli() {
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("GYM-MANAGEMENT-PANEL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setOpaque(false);
        titleLabel.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setOpaque(false);

        yoneticiGirisButton = createButton("Yönetici Girişi", "/assets/manager.png");
        antrenorGirisButton = createButton("Antrenör Girişi", "/assets/trainer.png");
        personelGirisButton = createButton("Personel Girişi", "/assets/staff.png");

        buttonPanel.add(yoneticiGirisButton);
        buttonPanel.add(antrenorGirisButton);
        buttonPanel.add(personelGirisButton);

        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setIcon(resizeIcon(new ImageIcon(getClass().getResource(iconPath)), 50, 50)); // İkon boyutunu ayarladık
        button.setPreferredSize(new Dimension(300, 80)); // Buton boyutunu ayarladık
        button.setHorizontalTextPosition(SwingConstants.RIGHT); // İkon ve metin konumlarını ayarladık
        button.setFont(new Font("Arial", Font.PLAIN, 18)); // Yazı tipini ayarladık
        return button;
    }

    private Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void setYoneticiGirisButtonListener(ActionListener listener) {
        yoneticiGirisButton.addActionListener(listener);
    }

    public void setAntrenorGirisButtonListener(ActionListener listener) {
        antrenorGirisButton.addActionListener(listener);
    }

    public void setPersonelGirisButtonListener(ActionListener listener) {
        personelGirisButton.addActionListener(listener);
    }
}
