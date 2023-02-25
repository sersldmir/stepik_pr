package Grass;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Grass {
    static JFrame frame = new JFrame();
    static int size=50;

    public static class AddTextura {
        public JLabel l;
        public AddTextura(BufferedImage im, int i, int j) {
            l = new JLabel(new ImageIcon(im));
            l.setBounds(i*size, j*size, size, size);
            frame.add(l);
        }
    }

    public static void main(String[] args) throws IOException {
        int width=800, height=600;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Grass");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        BufferedImage im = ImageIO.read(new URL("https://avatars.mds.yandex.net/i?id=6b677e370e194933d0aec45d1a46a59f-5314773-images-thumbs&n=13")).getSubimage(0,0,size,size);
        for (int i = 0; i <= width/size; i++)
            for (int j = 0; j <= height/size; j++)
                new AddTextura(im,i,j);
        frame.setVisible(true);
    }
}