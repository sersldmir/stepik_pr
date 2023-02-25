package Quiz;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static int curQuestion=0, allQuestion, allTrue;
    private static String curTrue;
    private static Document doc;
    private static JLabel label;
    private static JTextArea textArea;
    private static final JFrame frame = new JFrame();
    private static final JPanel panel1 = new JPanel (new GridBagLayout()), panel2 = new JPanel (new GridBagLayout()), panel3 = new JPanel (new GridBagLayout());//создаем панели
    private static final GridBagConstraints gbc = new GridBagConstraints();

    private static void nextQuestion() {
        curQuestion++;
        label.setText("Вопрос "+curQuestion+" из "+allQuestion);

        Color greenColor = new Color(0, 205, 102);
        Color yellowColor = new Color(240, 230, 140);
        Color orangeColor = new Color(255, 165, 0);
        Color redColor = new Color(205, 92, 92);

        Node question = doc.getElementsByTagName("name").item(curQuestion-1);
        textArea.setText(question.getTextContent());
        curTrue=question.getAttributes().getNamedItem("true").getTextContent();
        Element answersElement = (Element) doc.getElementsByTagName("answers").item(curQuestion - 1);
        NodeList answers = answersElement.getElementsByTagName("answer");

        var buttons = new ArrayList<JButton>();
        Font fontButton = new Font("Arial", Font.PLAIN, 20);
        panel3.removeAll();
        for (int i = 0; i < answers.getLength(); i++) {
            buttons.add(new JButton(String.valueOf(i)));
            JButton newButton = buttons.get(i);
            newButton.setFont(fontButton);
            newButton.setText(answers.item(i).getTextContent());
            panel3.add(newButton, gbc);

            if (String.valueOf(i+1).equals(curTrue))
                curTrue = answers.item(i).getTextContent();

            newButton.addActionListener(e -> {
                if (newButton.getText().equals(curTrue)) {
                    allTrue++;
                    newButton.setBackground(greenColor);
                } else
                    newButton.setBackground(redColor);
                for (JButton b:buttons)
                    b.setEnabled(false);
                frame.setVisible(true);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (curQuestion < allQuestion) nextQuestion();
                        else {
                            int percent = allTrue*100/allQuestion;
                            panel2.removeAll();
                            frame.remove(panel1);
                            frame.remove(panel3);
                            if (percent>74) panel2.setBackground(greenColor);
                                else if (percent<25) panel2.setBackground(redColor);
                                    else if (percent<50) panel2.setBackground(orangeColor);
                                        else panel2.setBackground(yellowColor);
                            JLabel labelResult = new JLabel("Правильных ответов: " + allTrue + " из " + allQuestion + " или " + percent + "%", SwingConstants.CENTER);
                            labelResult.setFont(fontButton);
                            panel2.add(labelResult, gbc);
                            frame.setVisible(true);
                        }
                    }
                }, 1000);
              });
        }
        frame.pack();
        frame.setVisible(true);
    }

    static void openXML() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("quiz.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        doc = documentBuilder.parse(file);
        allQuestion=doc.getElementsByTagName("question").getLength();
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width=1000, height=500;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);

        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panel2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panel3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        label = new JLabel();
        panel1.add(label,gbc);

        textArea = new JTextArea();
        textArea.setEnabled(false);
        textArea.setLineWrap(true);
        textArea.setColumns(30);
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setDisabledTextColor(Color.BLACK);
        panel2.add(textArea,gbc);

        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel3,BorderLayout.SOUTH);

        openXML();
        nextQuestion();
    }
}
