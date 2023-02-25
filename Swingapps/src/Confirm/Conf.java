package Confirm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Conf {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Три диалоговых окна");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=400, height=200;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel = new JPanel ();
        panel.setFocusable(true);
        frame.add(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    int result1 = JOptionPane.showConfirmDialog(panel, "Знаете, что такое интернет?", "Первый вопрос", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    int result2 = JOptionPane.showConfirmDialog(panel, "Судимость есть?", "Второй вопрос", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    String result;
                    if ((result1 != 0 && result2 == 0) || (result1 != 0 && result2 != 0)) result = "Дома сиди, дикарь";
                    else if (result1 == 0 && result2 != 0) result = "Вы приняты на позицию фрот-эндера, поздравляю!";
                    else result = "Сидевших не берем";
                    JOptionPane.showMessageDialog(panel, result, "Ответ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}
