package SimpleTeleport;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Tp {
        static JFrame frame = new JFrame();
        static JLabel l;
        static int width=300, height=300;
        static int change=50;

        static public void move(KeyEvent e){
            switch (e.getKeyCode()){
                case (KeyEvent.VK_LEFT):
                    if (l.getX()-change>=0)
                        l.setLocation(l.getX()-change,l.getY());
                    break;
                case (KeyEvent.VK_RIGHT):
                    if (l.getX()+change<width-l.getWidth())
                        l.setLocation(l.getX()+change,l.getY());
                    break;
                case (KeyEvent.VK_UP):
                    if (l.getY()-change>=0)
                        l.setLocation(l.getX(),l.getY()-change);
                    break;
                case (KeyEvent.VK_DOWN):
                    if (l.getY()+change<height-l.getHeight())
                        l.setLocation(l.getX(),l.getY()+change);
                    break;
            }
        }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TP");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
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