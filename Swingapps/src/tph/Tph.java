package tph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Tph {
        static JFrame frame = new JFrame();
        static JLabel l;
        static int change=50;

        static public void move(KeyEvent e){
            switch (e.getKeyCode()){
                case (KeyEvent.VK_LEFT):
                    l.setLocation(l.getX()-change>=0?l.getX()-change:(int) frame.getContentPane().getSize().getWidth()-l.getWidth()-5,l.getY());
                    break;
                case (KeyEvent.VK_RIGHT):
                    l.setLocation(l.getX()+change<(int) frame.getContentPane().getSize().getWidth()-l.getWidth()?l.getX()+change:5,l.getY());
                    break;
                case (KeyEvent.VK_UP):
                    l.setLocation(l.getX(),l.getY()-change>=0?l.getY()-change:(int) frame.getContentPane().getSize().getHeight()-l.getHeight()+5);
                    break;
                case (KeyEvent.VK_DOWN):
                    l.setLocation(l.getX(),l.getY()+change<(int) frame.getContentPane().getSize().getHeight()-l.getHeight()?l.getY()+change:5);
                    break;
            }
        }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tph");
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
