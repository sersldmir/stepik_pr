package httpReq;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Historyday {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Введите корректный номер месяца (от 1 до 12):");
            month = scanner.nextInt();
        }
        int day;
        switch (month) {
            case 2 -> {
                System.out.println("Введите номер дня (от 1 до 29):");
                day = scanner.nextInt();
                while (day < 1 || day > 29) {
                    System.out.println("Введите корректное число месяца (от 1 до 29):");
                    day = scanner.nextInt();
                }
            }
            case 4, 6, 9, 11 -> {
                System.out.println("Введите номер дня  (от 1 до 30):");
                day = scanner.nextInt();
                while (day < 1 || day > 30) {
                    System.out.println("Введите корректное число месяца (от 1 до 30):");
                    day = scanner.nextInt();
                }
            }
            default -> {
                System.out.println("Введите номер дня  (от 1 до 31):");
                day = scanner.nextInt();
                while (day < 1 || day > 31) {
                    System.out.println("Введите корректное номер дня  (от 1 до 31):");
                    day = scanner.nextInt();
                }
            }
        }
        scanner.close();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://numbersapi.com/" + month + "/" + day + "/date")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
