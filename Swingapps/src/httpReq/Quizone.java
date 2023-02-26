package httpReq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Quizone {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, JSONException {
        System.out.println("Введите число, из скольки вопросов хотите пройти викторину");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String url = "http://jservice.io/api/random?count="+n;
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body().toString();
        JSONArray array = new JSONArray(jsonString);
        int cnt = 0;
        for (int i = 0; i < n; i++){
            Scanner sc2 = new Scanner(System.in);
            JSONObject obj = array.getJSONObject(i);
            String answer = (String) obj.get("answer");
            String question = (String) obj.get("question");
            System.out.println("Question: " + question);
            System.out.print("Введите ответ: ");
            String input = sc2.nextLine();
            if (answer.equals(input)) {
                cnt++;
                System.out.println("Ответ верный!");
            } else {
                System.out.println("Неверно! Правильный ответ: " + answer);
            }
        }
        System.out.println("Игра окончена! Вы набрали " + cnt + " баллов из " + n + "!");
    }
}
