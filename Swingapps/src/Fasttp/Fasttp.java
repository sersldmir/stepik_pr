package Fasttp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Fasttp {
    static JFrame frame = new JFrame();
        static JLabel l;
        static int change=50;

        static public void move(KeyEvent e){
            int thisChange=e.isShiftDown() ? change*2 : change;
            switch (e.getKeyCode()){
                case (KeyEvent.VK_LEFT):
                    if (l.getX()-thisChange>=0)
                        l.setLocation(l.getX()-thisChange,l.getY());
                    else {
                        if (e.isShiftDown() && l.getX() <= l.getWidth())
                            l.setLocation((int) frame.getContentPane().getSize().getWidth() - l.getWidth()*2 - 5, l.getY());
                        else
                            l.setLocation((int) frame.getContentPane().getSize().getWidth() - l.getWidth() - 5, l.getY());
                    }
                    break;
                case (KeyEvent.VK_RIGHT):
                    if (l.getX()+thisChange<(int) frame.getContentPane().getSize().getWidth()-l.getWidth())
                        l.setLocation(l.getX()+thisChange,l.getY());
                    else {
                        if (e.isShiftDown()&&frame.getContentPane().getSize().getWidth()-l.getX()<=l.getWidth()*2)
                            l.setLocation(5+l.getWidth(), l.getY());
                        else
                            l.setLocation(5, l.getY());
                    }
                    break;
                case (KeyEvent.VK_UP):
                    if (l.getY()-thisChange>=0)
                        l.setLocation(l.getX(),l.getY()-thisChange);
                    else {
                        if (e.isShiftDown() && l.getY() <= l.getHeight())
                            l.setLocation(l.getX(), (int) frame.getContentPane().getSize().getHeight() - l.getHeight()*2 + 5);
                        else
                            l.setLocation(l.getX(), (int) frame.getContentPane().getSize().getHeight() - l.getHeight() + 5);
                    }
                    break;
                case (KeyEvent.VK_DOWN):
                    if (l.getY()+thisChange<(int) frame.getContentPane().getSize().getHeight()-l.getHeight())
                        l.setLocation(l.getX(),l.getY()+thisChange);
                    else {
                        if (e.isShiftDown()&&frame.getContentPane().getSize().getHeight()-l.getY()<=l.getHeight()*2)
                            l.setLocation(l.getX(), 5+l.getHeight());
                            else
                        l.setLocation(l.getX(), 5);
                    }
                    break;
            }
        }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fasttp");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=300, height=300;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        BufferedImage im = ImageIO.read(new URL("https://www.gravatar.com/avatar/1e34435a30921642e976c2a1001dcee0?s=50&d=mm&r=pg"));
        JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT));
        panel.setFocusable(true);
        l = new JLabel(new ImageIcon(im),JLabel.RIGHT);
        panel.add(l, BorderLayout.NORTH);
        frame.add(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                move(e);
            }
        });
        frame.setVisible(true);
    }
}
