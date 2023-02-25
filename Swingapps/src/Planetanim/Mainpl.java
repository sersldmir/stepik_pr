package Planetanim;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Mainpl extends Canvas{
    static int width = 900, height = 900;//размеры окна

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("Planets-ish");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        BufferedImage screamHead = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/ChippyDuck/png/1.png"));
        BufferedImage sunnyHead = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/CursedPixelMoji/png/1.png"));
        BufferedImage screamHead2 = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/chrisvk/png/42.png"));
        int screamHeadWidth = screamHead.getWidth(); 
        int screamHeadHeight = screamHead.getHeight();
        int sunnyHeadWidth = sunnyHead.getWidth();
        int sunnyHeadHeight = sunnyHead.getHeight();
        int screamHead2Width = screamHead2.getWidth();
        int screamHead2Height = screamHead2.getHeight();
        JLabel wIcon = new JLabel(new ImageIcon(screamHead));
        JLabel wIcon2 = new JLabel(new ImageIcon(sunnyHead));
        JLabel wIcon3 = new JLabel(new ImageIcon(screamHead2));
        int startX = width / 2 - screamHeadWidth / 3, startY = height / 20;
        int startX2 = width/2 - screamHead2Width / 2, startY2 = height / 20;
        int newStartX = width / 2 - sunnyHeadWidth / 2, newStartY = height / 2 - sunnyHeadHeight / 2;
        wIcon.setBounds(newStartX, newStartY, sunnyHeadWidth, sunnyHeadHeight);
        wIcon2.setBounds(startX,startY,screamHeadWidth,screamHeadHeight);
        wIcon3.setBounds(startX2,startY2,screamHead2Width,screamHead2Height);
        frame.add(wIcon);
        frame.add(wIcon2);
        frame.add(wIcon3);
        int radius1=Math.max(width-100, height-100)/2-Math.max(sunnyHeadWidth, sunnyHeadHeight);
        int radius2 = Math.max(width+100, height+100)/2-Math.max(sunnyHeadWidth, sunnyHeadHeight);
        int deltaX=width/2-sunnyHeadWidth/2, deltaY=height/2-sunnyHeadHeight/2;
        for (int t = 0; t < 360;) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            wIcon2.setBounds((int) (radius1*Math.cos(t*Math.PI/180))+deltaX, (int) (radius1*Math.sin(t*Math.PI/180))+deltaY, sunnyHeadWidth, sunnyHeadHeight);
            wIcon2.repaint();
            wIcon3.setBounds((int) (radius2*Math.cos(t*Math.PI/180))+deltaX, (int) (radius2*Math.sin(t*Math.PI/180))+deltaY, sunnyHeadWidth, sunnyHeadHeight);
            wIcon3.repaint();
            t=t==359?0:t+1;
        }



    }
}
