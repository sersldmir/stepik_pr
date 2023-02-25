package drag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class Drag {
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel("Текст для перетаскивания");
    static Point startPoint;
    static boolean move=false;

    public static void start(MouseEvent e){
        if (e.getButton()==3)
        {
            startPoint = e.getPoint();
            move=true;
        }
    }

    public static void stop(MouseEvent e){
        move=false;
    }

    public static void move(MouseEvent e){
        if (move) {
            Point p = SwingUtilities.convertPoint(label, e.getPoint(), panel);
            label.setLocation(p.x - startPoint.x, p.y - startPoint.y);
        }
    }

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drag and drop");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 400, height = 400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        frame.add(panel);
        panel.add(label);
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                start(e);
            }
        });
        label.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                stop(e);
            }
        });
        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                move(e);
            }
        });
        frame.setVisible(true);
    }
}
