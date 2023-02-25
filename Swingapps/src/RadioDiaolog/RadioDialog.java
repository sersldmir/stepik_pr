package RadioDiaolog;

import javax.swing.*;
import java.awt.*;

public class RadioDialog {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("RadioDialog");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton dim1 = new JRadioButton("800x600", true);
        JRadioButton dim2 = new JRadioButton("1024x768", false);
        JRadioButton dim3 = new JRadioButton("1200x600", false);
        JRadioButton dim4 = new JRadioButton("1280x1024", false);
        JRadioButton dim5 = new JRadioButton("1680x1050", false);
        JRadioButton dim6 = new JRadioButton("1920x1080", false);
        dim1.setActionCommand("800х600");
        dim2.setActionCommand("1024x768");
        dim3.setActionCommand("1200x600");
        dim4.setActionCommand("1280x1024");
        dim5.setActionCommand("1680x1050");
        dim6.setActionCommand("1920x1080");
        buttons.add(dim1);
        buttons.add(dim2);
        buttons.add(dim3);
        buttons.add(dim4);
        buttons.add(dim5);
        buttons.add(dim6);
        JPanel panel = new JPanel ();
        panel.add(dim1);
        panel.add(dim2);
        panel.add(dim3);
        panel.add(dim4);
        panel.add(dim5);
        panel.add(dim6);
        JOptionPane.showMessageDialog(frame, panel, "Выберите разрешение", JOptionPane.QUESTION_MESSAGE);
        String result = buttons.getSelection().getActionCommand();
        int width = Integer.parseInt(result.substring(0,result.lastIndexOf("x")));
        int height = Integer.parseInt(result.substring(result.lastIndexOf("x")+1));
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        frame.setVisible(true);
    }
}
