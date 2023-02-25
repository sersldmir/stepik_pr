package Choice;

import javax.swing.*;
import java.awt.*;

public class Choice {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Choice");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        String [] selectDim = new String[]{"800x600","1024x768","1200x600","1280x1024","1680x1050","1920x1080"};
        new JOptionPane();
        Object result = JOptionPane.showInputDialog(frame, "Выберите разрешение", "Выбор разрешения", JOptionPane.QUESTION_MESSAGE,null,selectDim,selectDim[0]);
        int width= Integer.parseInt(result.toString().substring(0,result.toString().lastIndexOf("x")));
        int height = Integer.parseInt(result.toString().substring(result.toString().lastIndexOf("x")+1));
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        frame.setVisible(true);
    }
}
