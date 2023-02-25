package Dialogim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dialogim {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dialogim");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=400, height=200;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel = new JPanel ();
        panel.setFocusable(true);
        frame.add(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_SPACE)
                {
                    JOptionPane pane = new JOptionPane();
                    String result = JOptionPane.showInputDialog(panel, "Как вас зовут?", "Вопрос", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog (pane, result,"Ответ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}
