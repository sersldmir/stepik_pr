package Log_pas;

import javax.swing.*;
import java.awt.*;

public class LogPass {
    public static void main(String[] args) {
        String login, pass;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Авторизация");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 600, height = 300;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        if (JOptionPane.showConfirmDialog(frame, "Будем регистрироваться?", "Вопрос", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
            while (true) {
                login = JOptionPane.showInputDialog(frame, "Введите логин", "Логин", JOptionPane.QUESTION_MESSAGE);
                if (login==null)
                    System.exit(0);
                else
                    if (login.length()>5 && login.lastIndexOf(" ")==-1) break;
            }
            JPasswordField pf = new JPasswordField();
            while (true) {
                if (JOptionPane.showConfirmDialog(frame, pf, "Введите пароль для логина "+login, JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION)
                    System.exit(0);
                else {
                    pass = new String(pf.getPassword());
                    if (pass.length() > 8 &&
                            pass.lastIndexOf(" ") == -1 &&
                            pass.chars().filter(Character::isDigit).count() > 0 &&
                            pass.chars().filter(Character::isLetter).count() > 0)
                        break;
                }
            }
            pf.setText("");
            while (true) {
                if (JOptionPane.showConfirmDialog(frame, pf, "Повторите пароль для логина "+login, JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION)
                    System.exit(0);
                else
                    if (new String(pf.getPassword()).equals(pass))
                        break;
            }
            JOptionPane.showMessageDialog(frame,"Поздравляем с успешной регистрацией","Успешная регистрация", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        }
        else  System.exit(0);
    }
}
