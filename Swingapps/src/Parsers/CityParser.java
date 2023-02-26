package Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class CityParser {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.krylatskoye.ru/content/ratings/2021/09/0928.html").get();
        Element table = doc.select("table").first();
        Elements rows = table.select("tr");
        String[] cities = new String[100];
        for (int i = 2; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            cities[i - 2] = cols.get(1).text();
        }
        Arrays.sort(cities);
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
