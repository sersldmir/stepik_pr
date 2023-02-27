package YandexPartOne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Ermitage extends JFrame{

    private JPanel panel;
    private JButton button;
    private JLabel label;


    public Ermitage() throws HeadlessException {
        super("Эрмитаж");
    }

    public void run() {
        addGui();
        addButtonActionListener();
    }

    public void addGui() {
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addButtonActionListener() {
        button.addActionListener(e -> {
            try {
                addImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void addImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?ll=30.314148,59.940082&z=16&l=map"));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new Ermitage().run();
    }


}
