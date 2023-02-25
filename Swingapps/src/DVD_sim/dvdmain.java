package DVD_sim;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;


public class dvdmain extends Canvas{
    static int width = 750, height = 750;//размеры окна

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("орущая голова");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);


        BufferedImage screamHead = ImageIO.read(new File("cute-cat.jpg"));
        int screamHeadWidth = screamHead.getWidth() / 2; 
        int screamHeadHeight = screamHead.getHeight() / 3;
        JLabel wIcon = new JLabel(new ImageIcon(screamHead));
        int startX = (int) (Math.random() * (width - screamHeadWidth)), startY = (int) (Math.random() * (height - screamHeadHeight));
        wIcon.setBounds(startX, startY, screamHeadWidth, screamHeadHeight);
        frame.add(wIcon);
        while (true) {
            int newX = (int) (Math.random() * (width - screamHeadWidth)), newY = (int) (Math.random() * (height - screamHeadHeight));
            int[][] path = drawBresenhamLine(startX, startY, newX, newY);
            startX = newX;
            startY = newY;
            for (int i = 5; i < path.length; i += 5) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                wIcon.setBounds(path[i][0], path[i][1], screamHeadWidth, screamHeadHeight);
                wIcon.repaint();
            }
        }

    }


    public static int[][] drawBresenhamLine(int xstart, int ystart, int xend, int yend){

        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

        dx = xend - xstart;
        dy = yend - ystart;

        incx = sign(dx);
        incy = sign(dy);
        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;
        if (dx > dy)
        {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        } else
        {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }
        x = xstart;
        y = ystart;
        err = el / 2;
        int[][] a = new int[el + 1][2];
        a[0][0] = x;
        a[0][1] = y;
        for (int t = 0; t < el; t++)
        {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;
                y += incy;
            } else {
                x += pdx;
                y += pdy;
            }
            a[t + 1][0] = x;
            a[t + 1][1] = y;
        }
        return a;
    }

    private static int sign(int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }
}
