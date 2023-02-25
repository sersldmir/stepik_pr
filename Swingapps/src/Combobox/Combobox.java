package Combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combobox {
    static JPanel panel = new JPanel ();//создаем панель
    
    static void addObject(JComponent o, int n, float alignmentX){
        o.setAlignmentX(alignmentX);
        panel.add(o);
        panel.add(Box.createVerticalStrut(n));
    };
    
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Комбобокс, чекбокс и текстбокс");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=600, height=400;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Красный");
        comboBox.addItem("Оранжевый");
        comboBox.addItem("Зеленый");
        comboBox.setMaximumSize(new Dimension(100,30));
        addObject(comboBox,10,Component.CENTER_ALIGNMENT);

        JCheckBox checkBox = new JCheckBox("Свой вариант");
        addObject(checkBox,10,Component.CENTER_ALIGNMENT);

        JTextField textBox = new JTextField();
        textBox.setEnabled(false);
        textBox.setMaximumSize(new Dimension(100,30));
        addObject(textBox,10,Component.CENTER_ALIGNMENT);

        JButton button = new JButton("Ответить");
        addObject(button,10,Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel("Ответ:");
        addObject(label,10,Component.CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Ответ: "+(checkBox.isSelected()?textBox.getText():comboBox.getSelectedItem().toString()));
            }
        });

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textBox.setEnabled(checkBox.isSelected());
                comboBox.setEnabled(!checkBox.isSelected());
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
