package YandexPartOne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Kazan extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JSlider slider;

    public Kazan() throws HeadlessException {
        super("Казань");
    }

    public void run() {
        addGui();
        addSliderActionListener();
    }

    public void addGui() {
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void addSliderActionListener() {
        slider.addChangeListener(e -> {
            try {
                setImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void setImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?ll=49.106414,55.796127&l=map&pt=49.106414,55.796127,flag&z=" + slider.getValue()));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new Kazan().run();
    }
}
