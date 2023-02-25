package Clicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Clicker");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=300, height=200;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel = new JPanel ();
        JLabel label = new JLabel("0", SwingConstants.CENTER);
        JButton button = new JButton("Push me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(Integer.valueOf(label.getText())+1));
            }
        });
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(label,BorderLayout.CENTER);
        panel.add(button,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
