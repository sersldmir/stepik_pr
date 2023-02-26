package httpReq;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HistoryCalendar extends JFrame{
    private JPanel panel;
    private JButton button;
    private JTextArea textArea;

    HistoryCalendar () {
        super("Этот день в истории");

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);

        button.addActionListener(e -> {
            try {
                HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://numbersapi.com/" + datePicker.getModel().getMonth() + "/" + datePicker.getModel().getDay() + "/date")).GET().build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                textArea.setText(response.body());
            } catch (URISyntaxException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        panel.add(datePicker);
        panel.add(button);
        panel.add(textArea);
        add(panel);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HistoryCalendar();
    }
}
