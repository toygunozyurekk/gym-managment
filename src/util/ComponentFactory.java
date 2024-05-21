package util;

import java.awt.*;
import javax.swing.*;

public class ComponentFactory {

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        return label;
    }

    public static JTextField createTextField() {
        JTextField textField = new JTextField(15);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        return textField;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 30));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        return button;
    }
}
