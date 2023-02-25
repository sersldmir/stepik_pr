package Race;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Race {
    static int width = 1200, height = 800;
    static JFrame frame = new JFrame();
    static int num=-1;

    public static class RunCar extends Thread {
        CreateCar car;
        public RunCar(CreateCar car) {
            this.car = car;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            while (num==-1) {
                try {
                    Thread.sleep(4);
                    car.l.setBounds(car.l.getX()+(int) (Math.random() * 5), car.l.getY(), car.l.getWidth(), car.l.getHeight());
                    if (car.l.getX()+car.l.getWidth()>=width-10) {
                        if (num==-1) num=car.num+1;
                        JLabel rez = new JLabel();
                        rez.setText(String.valueOf(num));
                        rez.setFont(new Font("Arial", Font.BOLD, 50));
                        rez.setBounds(width / 2, height / 2, 140, 40);
                        frame.add(rez);
                        rez.repaint();
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static class CreateCar{
        public int num;
        public JLabel l;
        public CreateCar(BufferedImage im, int y, int num) {
            this.num=num;
            l = new JLabel(new ImageIcon(im));
            l.setBounds(10, y, im.getWidth(), im.getHeight());
            frame.add(l);
        }
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Гонки");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        BufferedImage im = ImageIO.read(new URL("https://naves74.ru/images/png_araba_resimleri-wwwnisanboard_94.png?crc=4145026359"));
        frame.setVisible(true);
        int car = 5;
        for (int i = 0; i < car; i++)
            new RunCar (new CreateCar(im,height/car*i,i)).start();
    }
}
