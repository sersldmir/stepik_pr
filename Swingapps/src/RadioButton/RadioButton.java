package RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class RadioButton {
    static JPanel panel = new JPanel ();
    
    static void addObject(JComponent o, int n, float alignmentX){
        o.setAlignmentX(alignmentX);
        panel.add(o);
        if (n>0) panel.add(Box.createVerticalStrut(n));
    };
    
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Радиобаттон");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=600, height=400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);

        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton dim1 = new JRadioButton("Весна", month>2&&month<6?true:false);
        JRadioButton dim2 = new JRadioButton("Лето", month>5&&month<9?true:false);
        JRadioButton dim3 = new JRadioButton("Осень", month>8&&month<12?true:false);
        JRadioButton dim4 = new JRadioButton("Зима", month>11||month<3?true:false);
        dim1.setActionCommand("Весна");
        dim2.setActionCommand("Лето");
        dim3.setActionCommand("Осень");
        dim4.setActionCommand("Зима");
        buttons.add(dim1);
        buttons.add(dim2);
        buttons.add(dim3);
        buttons.add(dim4);
        addObject(dim1,0,Component.LEFT_ALIGNMENT);
        addObject(dim2,0,Component.LEFT_ALIGNMENT);
        addObject(dim3,0,Component.LEFT_ALIGNMENT);
        addObject(dim4,10,Component.LEFT_ALIGNMENT);

        JButton button = new JButton("Ответить");
        addObject(button,10,Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel("Ответ:");
        addObject(label,10,Component.LEFT_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Ответ: "+buttons.getSelection().getActionCommand());
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
