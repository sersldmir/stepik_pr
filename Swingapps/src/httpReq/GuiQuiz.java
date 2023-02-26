package httpReq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GuiQuiz extends JFrame{
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;
    private int counter = 0;
    private int numberQuestion = 0;
    List<String> answers = new ArrayList<>();
    List<String> questions = new ArrayList<>();

    GuiQuiz() throws URISyntaxException, IOException, InterruptedException, JSONException {
        super("Викторина");
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://jservice.io/api/random?count=8")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();
        JSONArray array = new JSONArray(jsonString);
        for (int i = 0; i < 8; i++) {
            JSONObject obj = array.getJSONObject(i);
            answers.add((String) obj.get("answer"));
            questions.add((String) obj.get("question"));
        }
        textArea.setText("Question 1: " + questions.get(0) + "?" + " (" + answers.get(0) + ")");
        button.addActionListener(e -> next());
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void next() {
        String choice = textField.getText();
        if (choice.equals(answers.get(numberQuestion))) counter++;
        textField.setText("");
        if (numberQuestion == 7) {
            textArea.setText("Вы ответили верно на " + counter + " из 8 вопросов");
            return;
        }
        numberQuestion++;
        textArea.setText("Question " + (numberQuestion + 1) + ": " + questions.get(numberQuestion) + "?" + " (" + answers.get(numberQuestion) + ")");
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, JSONException {
        new GuiQuiz();
    }
}
