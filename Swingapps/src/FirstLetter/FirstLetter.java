package FirstLetter;

import javax.swing.*;
import java.awt.*;

public class FirstLetter {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Первая надпись");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=800, height=600;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel = new JPanel ();
        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Verdana", Font.ITALIC, 50));
        frame.add(panel);
        panel.add(label);
        frame.setVisible(true);
    }
}
