package httpReq;

import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CuteAnimals extends JFrame{
    private JPanel panel;
    private JButton catButton;
    private JButton dogButton;
    private JButton foxButton;
    private JLabel label;

    CuteAnimals() {
        super("Animals");
        actionListeners();
        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void actionListeners() {
        catButton.addActionListener(e -> {
            try {
                setImage(getCat());
            } catch (URISyntaxException | IOException | InterruptedException | JSONException ex) {
                throw new RuntimeException(ex);
            }
        });
        dogButton.addActionListener(e -> {
            try {
                setImage(getDog());
            } catch (URISyntaxException | IOException | InterruptedException | JSONException ex) {
                throw new RuntimeException(ex);
            }
        });
        foxButton.addActionListener(e -> {
            try {
                setImage(getFox());
            } catch (URISyntaxException | IOException | InterruptedException | JSONException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    void setImage(String URL) throws IOException {
        Image image = ImageIO.read(new URL(URL)).getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(image));
    }

    String getCat() throws URISyntaxException, IOException, InterruptedException, JSONException {
        return "https://cataas.com" + getImage("https://cataas.com/cat?json=true", "url");
    }

    String getDog() throws URISyntaxException, IOException, InterruptedException, JSONException {
        return getImage("https://dog.ceo/api/breeds/image/random", "message");
    }

    String getFox() throws URISyntaxException, IOException, InterruptedException, JSONException {
        return getImage("https://randomfox.ca/floof/", "image");
    }

    String getImage(String url, String key) throws URISyntaxException, IOException, InterruptedException, JSONException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject obj = new JSONObject(response.body());
        return (String) obj.get(key);
    }

    public static void main(String[] args) throws IOException {
        new CuteAnimals();
    }
}
