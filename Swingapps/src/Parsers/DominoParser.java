package Parsers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DominoParser {
    public static void main(String[] args) throws IOException {
        Document main = Jsoup.connect("https://dominodomoy.ru/catalog/").get();
        Elements categories = main.getElementsByClass("catalog-section-list-item-title");
        for (Element category : categories) {
            System.out.println(category.text());
            Document detailCategory = Jsoup.connect("https://dominodomoy.ru" + category.attr("href")).get();
            Elements positions = detailCategory.getElementsByClass("catalog-section-item-background");
            for (Element position : positions) {
                String name = position.getElementsByClass("catalog-section-item-name-wrapper").text();
                String price = position.getElementsByClass("catalog-section-item-price-discount").text();
                String image = position.select("img").attr("data-original");
                System.out.println("\t" + name + " - " + price + " - https://dominodomoy.ru" + image);
            }
        }
    }
}
