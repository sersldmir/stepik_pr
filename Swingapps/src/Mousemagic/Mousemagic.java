package Mousemagic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mousemagic {
    static JFrame frame = new JFrame();
        static JLayeredPane panel = new JLayeredPane();

        static public void add(MouseEvent e){
            if (e.getButton()==1){
                JLabel label = new JLabel("X:"+e.getX()+" Y:"+e.getY());
                label.setBounds(e.getX(),e.getY(),100,20);
                panel.add(label);
            }
        }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Добавление мышкой");
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int width = 400, height = 400;
                frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
                panel.setFocusable(true);
                frame.add(panel);
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        add(e);
                    }
                });
                frame.setVisible(true);
            }
        });
    }
}
