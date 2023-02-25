package Change_font;

import javax.swing.*;
import java.awt.*;

public class Change_font {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ChangeFont");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
        frame.setLocationRelativeTo(null);
        JLabel label = new JLabel("Change the font!", SwingConstants.CENTER);
        label.setFont(new Font("Calibri", Font.ITALIC, 50));
        JSlider slider = new JSlider(5, 100, 50);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.addChangeListener(e -> label.setFont(new Font("Calibri", Font.ITALIC, slider.getValue())));
        frame.add(label);
        frame.add(slider, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
