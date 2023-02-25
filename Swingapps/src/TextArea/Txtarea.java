package TextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Txtarea {
    static JPanel panel = new JPanel ();
    static void addObject(JComponent o, int n, float alignmentX){
        o.setAlignmentX(alignmentX);
        panel.add(o);
        if (n>0) panel.add(Box.createVerticalStrut(n));
    };
    
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TextArea");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=600, height=400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JTextField textBox = new JTextField();
        textBox.setMaximumSize(new Dimension(300,30));
        addObject(textBox,10,Component.CENTER_ALIGNMENT);
        JButton button = new JButton("Write");
        addObject(button,10,Component.CENTER_ALIGNMENT);
        JTextArea textArea = new JTextArea();
        textArea.setRows(4);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setMaximumSize(new Dimension(300,100));
        addObject(scroll,10,Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText()+(textArea.getText().length()==0?"":"\n")+textBox.getText());
            }
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}
