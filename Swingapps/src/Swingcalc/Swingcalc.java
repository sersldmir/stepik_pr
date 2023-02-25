package Swingcalc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Swingcalc {
    static JFrame frame = new JFrame();
    static JTextField textBox = new JTextField();
    static String n1="",n2="",op="";

    private static double caclulate() {
        return switch (op) {
            case "+" -> Double.parseDouble(n1) + Double.parseDouble(n2);
            case "-" -> Double.parseDouble(n1) - Double.parseDouble(n2);
            case "*" -> Double.parseDouble(n1) * Double.parseDouble(n2);
            case "/" -> Double.parseDouble(n1) / Double.parseDouble(n2);
            default -> 0;
        };
    }

    public static void main(String[] args) {
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Калькулятор");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=400, height=250;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel1 = new JPanel (), panel2 = new JPanel ();
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(4,4,1,1));
        panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panel2.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        textBox.setEnabled(false);
        textBox.setFont(new Font("Arial", Font.PLAIN, 20));
        textBox.setDisabledTextColor(Color.BLACK);
        panel1.add(textBox);
        var buttons = new ArrayList<JButton>();
        String [] nameButtons = new String[] {"1","2","3","+","4","5","6","-","7","8","9","*","C","0","=","/"};
        Font fontButton = new Font("Arial", Font.BOLD, 35);
        for (String name: nameButtons) {
            buttons.add(new JButton(name));
            JButton newButton =  buttons.get(buttons.size() - 1);
            newButton.setFont(fontButton);
            panel2.add(newButton);
            newButton.addActionListener(e -> {
                String text = textBox.getText();
                String b = newButton.getText();
                switch (b) {
                    case "C":
                        textBox.setText("");
                        n1="";
                        n2="";
                        op="";
                        break;
                    case "=":
                        if (n1.length()>0&&n2.length()>0&&op.length()>0){
                            double result = caclulate();
                            textBox.setText(result%1==0?Integer.toString((int) result): String.valueOf(result));
                            n1=textBox.getText();
                            n2="";
                            op="";
                        }
                        break;
                    case "+","-","*","/":
                        if (n1.length() > 0 && op.length() == 0){
                            textBox.setText(text+b);
                            op=b;
                        }
                        break;
                    case "0":
                        if (op.equals("/") && n2.length() == 0)
                            break;
                    default:
                            if (op.length() == 0 & !n1.equals("0")) {
                                n1 = n1 + b;
                                textBox.setText(text+b);
                            }
                            if (op.length() != 0 & !n2.equals("0")) {
                                n2 = n2 + b;
                                textBox.setText(text+b);
                            }
                        }
            });
        }
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
