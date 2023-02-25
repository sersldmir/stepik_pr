package Change_Cursor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chcur {
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();

    public static void changeCursor(MouseEvent e){
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public static void defaultCursor(MouseEvent e){
        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Изменения курсора мыши");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400, height = 400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        panel.setFocusable(true);
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                changeCursor(e);
            }
            public void mouseExited(MouseEvent e) {
                defaultCursor(e);
            }
        });
        frame.setVisible(true);
    }
}
