package Swing_sq_anim;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Mainan extends Canvas {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("64 квадрата в квадрате в квадрате по квадрату");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-width/2,dim.height/2-height/2, width,height+30);
        Mainan m=new Mainan();
        frame.add(m);
        frame.setVisible(true);

    }

        private static final int width = 800, height = 800;        
        private Image image;

        public void paint(Graphics g) {
            try{
                BufferedImage wPic = ImageIO.read(new File("cute-cat.jpg"));
                image = wPic.getScaledInstance(wPic.getWidth() / 2, wPic.getHeight() / 2, Image.SCALE_DEFAULT);
                int imageWidth = wPic.getWidth()/2, imageHeight=wPic.getHeight()/2;
                int y = 50, x = y, d=y;
                while (true) {
                    if (x<width-d-imageWidth && y==d)
                        x++;
                    if (x==width-d-imageWidth && y<height-d-imageHeight)
                        y++;
                    if (x>d && y==height-d-imageHeight)
                        x--;
                    if (x==d && y>d)
                        y--;
                    g.drawImage(image, x, y, this);
                    try
                    {
                        Thread.sleep(5);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    g.clearRect(x, y, imageWidth, imageHeight);

                }
            } catch (IOException e) {
                g.drawString("Ошибка", 10,10);
            }
        }
}
