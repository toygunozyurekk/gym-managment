package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import util.ComponentFactory;

public class MusteriOdemePaneli extends JPanel {
    private final JTable odemeTablosu;
    private final JButton geriButton;
    private Image backgroundImage;

    public MusteriOdemePaneli() {
        // Arka plan görüntüsünü yükle
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/assets/background.jpeg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        String[] columnNames = {"Ad", "Soyad", "Telefon", "Yıl", "Ay", "Ödeme"};
        Object[][] data = {};
        odemeTablosu = new JTable(data, columnNames);
        odemeTablosu.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(odemeTablosu);

        // Tablo başlıklarını beyaz ve bold yap
        JTableHeader header = odemeTablosu.getTableHeader();
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.DARK_GRAY);

        // Tablo hücrelerini beyaz yap
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setForeground(Color.WHITE);
        cellRenderer.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < odemeTablosu.getColumnCount(); i++) {
            odemeTablosu.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        add(scrollPane, BorderLayout.CENTER);

        geriButton = ComponentFactory.createButton("Geri Dön");
        geriButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "AnaPanel");
        });
        add(geriButton, BorderLayout.SOUTH);
    }

    public void musteriOdemeleriniGuncelle(List<String[]> odemeler) {
        String[] columnNames = {"Ad", "Soyad", "Telefon", "Yıl", "Ay", "Ödeme"};
        Object[][] data = new Object[odemeler.size()][6];
        for (int i = 0; i < odemeler.size(); i++) {
            data[i] = odemeler.get(i);
        }
        odemeTablosu.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
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
