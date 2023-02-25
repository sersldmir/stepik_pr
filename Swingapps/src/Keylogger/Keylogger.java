package Keylogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Keylogger {
    static JFrame frame = new JFrame();
    static JLabel l;
    static final File file = new File("keylogger.txt");
    static FileWriter writer;

    static public void print(KeyEvent e) throws IOException {
        if (e.getKeyCode()!=KeyEvent.VK_ESCAPE) {
            l.setText(KeyEvent.getKeyText(e.getKeyCode()));
            writer.write(KeyEvent.getKeyText(e.getKeyCode()));
        }
        else {
            writer.flush();
            Stream log = Files.lines(Paths.get("keylogger.txt"));
            String temp = Arrays.deepToString(log.toArray());
            l.setText(temp.substring(1,temp.length()-1));
            log.close();
            PrintWriter tempWriter = new PrintWriter(file);
            tempWriter.print("");
            tempWriter.close();
        }
    }

public static void main(String[] args) throws IOException {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Запись клавиш");
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int width=600, height=100;
    frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
    JPanel panel = new JPanel (new FlowLayout(FlowLayout.CENTER));
    panel.setFocusable(true);
    l = new JLabel();
    panel.add(l, BorderLayout.CENTER);
    frame.add(panel);
    file.createNewFile();
    writer = new FileWriter(file);
    panel.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
            try {
                print(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    frame.setVisible(true);
}
}

