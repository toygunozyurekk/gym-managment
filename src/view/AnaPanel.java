package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AnaPanel extends JPanel {
    private final JLabel roleLabel;
    private final JLabel aylikButceLabel;
    private final JButton urunEkleButton;
    private final JButton urunCikarButton;
    private final JButton calisanEkleButton;
    private final JButton calisanCikarButton;
    private final JButton musteriEkleButton;
    private final JButton musteriCikarButton;
    private final JButton aylikButceButton;
    private final JButton musteriOdemeButton;
    private final JButton dersSaatiAyarlamaButton;
    private final JButton signOutButton;

    private Image backgroundImage; // Background image

    public AnaPanel() {
        // Load background image
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Transparent background

        urunEkleButton = createButton("Ürün Ekle", "/assets/add_icon.png");
        urunCikarButton = createButton("Ürün Çıkar", "/assets/remove_icon.png");
        calisanEkleButton = createButton("Çalışan Ekle", "/assets/add_icon.png");
        calisanCikarButton = createButton("Çalışan Çıkar", "/assets/remove_icon.png");
        musteriEkleButton = createButton("Müşteri Ekle", "/assets/add_icon.png");
        musteriCikarButton = createButton("Müşteri Çıkar", "/assets/remove_icon.png");
        aylikButceButton = createButton("Aylık Bütçe", "/assets/budget_icon.png");
        musteriOdemeButton = createButton("Müşteri Ödemeleri", "/assets/payment_icon.png");
        dersSaatiAyarlamaButton = createButton("Ders Saati Ayarla", "/assets/schedule_icon.png");
        signOutButton = createButton("Sign Out", "/assets/signout_icon.png");

        add(buttonPanel, BorderLayout.CENTER);

        roleLabel = new JLabel("Rol: ");
        aylikButceLabel = new JLabel("Aylık Bütçe: ");
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setOpaque(false); // Transparent background
        infoPanel.add(roleLabel, BorderLayout.WEST);
        infoPanel.add(aylikButceLabel, BorderLayout.EAST);

        add(infoPanel, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void setRole(String role) {
        roleLabel.setText("Rol: " + role);
        configureForRole(role);
    }

    public void setAylikButceLabel(String text) {
        aylikButceLabel.setText("Aylık Bütçe: " + text);
    }

    public void setUrunEkleButtonListener(ActionListener listener) {
        urunEkleButton.addActionListener(listener);
    }

    public void setUrunCikarButtonListener(ActionListener listener) {
        urunCikarButton.addActionListener(listener);
    }

    public void setCalisanEkleButtonListener(ActionListener listener) {
        calisanEkleButton.addActionListener(listener);
    }

    public void setCalisanCikarButtonListener(ActionListener listener) {
        calisanCikarButton.addActionListener(listener);
    }

    public void setMusteriEkleButtonListener(ActionListener listener) {
        musteriEkleButton.addActionListener(listener);
    }

    public void setMusteriCikarButtonListener(ActionListener listener) {
        musteriCikarButton.addActionListener(listener);
    }

    public void setAylikButceButtonListener(ActionListener listener) {
        aylikButceButton.addActionListener(listener);
    }

    public void setMusteriOdemeButtonListener(ActionListener listener) {
        musteriOdemeButton.addActionListener(listener);
    }

    public void setDersSaatiAyarlamaButtonListener(ActionListener listener) {
        dersSaatiAyarlamaButton.addActionListener(listener);
    }

    public void setSignOutButtonListener(ActionListener listener) {
        signOutButton.addActionListener(listener);
    }

    public void configureForRole(String role) {
        removeAll(); // Clear existing components

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Transparent background

        if (role.equalsIgnoreCase("Yönetici")) {
            buttonPanel.setLayout(new GridLayout(5, 2, 10, 10));
            buttonPanel.add(urunEkleButton);
            buttonPanel.add(urunCikarButton);
            buttonPanel.add(calisanEkleButton);
            buttonPanel.add(calisanCikarButton);
            buttonPanel.add(musteriEkleButton);
            buttonPanel.add(musteriCikarButton);
            buttonPanel.add(aylikButceButton);
            buttonPanel.add(musteriOdemeButton);
            buttonPanel.add(new JLabel());
            buttonPanel.add(signOutButton);

        } else if (role.equalsIgnoreCase("Antrenör")) {
            buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
            buttonPanel.add(musteriEkleButton);
            buttonPanel.add(musteriCikarButton);
            buttonPanel.add(musteriOdemeButton);
            buttonPanel.add(dersSaatiAyarlamaButton);
            buttonPanel.add(signOutButton);

        } else if (role.equalsIgnoreCase("Personel")) {
            buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
            buttonPanel.add(urunEkleButton);
            buttonPanel.add(urunCikarButton);
            buttonPanel.add(musteriEkleButton);
            buttonPanel.add(musteriCikarButton);
            buttonPanel.add(musteriOdemeButton);
            buttonPanel.add(signOutButton);
        }

        add(buttonPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setIcon(resizeIcon(new ImageIcon(getClass().getResource(iconPath)), 40, 40)); // Adjust icon size
        button.setPreferredSize(new Dimension(150, 50)); // Adjust button size
        button.setHorizontalTextPosition(SwingConstants.RIGHT); // Adjust icon and text positions
        return button;
    }

    private Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
