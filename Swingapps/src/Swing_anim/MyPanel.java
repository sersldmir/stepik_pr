package Swing_anim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {

    private static final int width = 800, height = 800;
    private Image image;
    private int x = -220, y = -220;

    public MyPanel() {
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(800, 800));
        loadImage();
        start();
    }

    private void loadImage() {
        try {
            BufferedImage wPic = ImageIO.read(new File("cute-cat.jpg"));
            image = wPic.getScaledInstance(wPic.getWidth() / 2, wPic.getHeight() / 2, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(image, x, y, null);
    }

    public void start() {
        Timer timer = new Timer(10, e -> nextStep());
        timer.start();
    }

    private void nextStep() {
        if(x > width || y > height) {
            x = -220;
            y = -220;
        }
        x += 3;
        y += 3;
        repaint();
    }

}