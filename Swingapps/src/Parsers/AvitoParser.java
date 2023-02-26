package Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


class Avito {

    private String title;
    private String price;
    private String yearOfProduction;
    private String condition;
    private String detailsLink;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    @Override
    public String toString() {
        return "Информация взята с сайта Avito: " +
                "Название модели = '" + title + '\'' +
                ", цена = '" + price + '\'' +
                ", год выпуска = '" + yearOfProduction + '\'' +
                ", состояние = '" + condition + '\'' +
                ", ссылка на сайт = '" + detailsLink + '\'' +
                '.';
    }

}

public class AvitoParser {

    private void parsAvito(){
        try {
            System.out.println("Подключение к странице");
            Document document = Jsoup.connect("https://www.avito.ru/saratovskaya_oblast/avtomobili?cd=1").get();
            List<Avito> avitos = new ArrayList<>();
    
            Elements avitoTitleElements = document.getElementsByAttributeValue("itemprop", "name");
    
            for (Element postTitleElement : avitoTitleElements) {
                String detailsLink = postTitleElement.attr("href");
                Avito avito = new Avito();
    
                avito.setDetailsLink(detailsLink);
                avito.setTitle(postTitleElement.attr("title")); 
                System.out.println("Подключение к деталям о посте " + detailsLink);
    
                Document detailsLinkDoc = Jsoup.connect(detailsLink).get();
    
                try {
                    Element priceElement = detailsLinkDoc.getElementsByAttributeValue("itemprop", "price").first().child(0);
                    avito.setPrice(priceElement.text());
                    Element yearOfProductElement = detailsLinkDoc.getElementsByClass("params-paramsList__item-1Xeok").first().child(0);
                    avito.setYearOfProduction(yearOfProductElement.text());
                    Element conditionElement = detailsLinkDoc.getElementsByClass("params-paramsList__item-1Xeok").first().child(0);
                    avito.setCondition(conditionElement.text());
    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    avito.setPrice("Цены нет");
                    avito.setYearOfProduction("Года нет");
                    avito.setDetailsLink("Ссылки нет");
                    avito.setCondition("Состояния нет");
                }
                avitos.add(avito);
            }
    
            avitos.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    }

    public static void main(String[] args) {
        AvitoParser pars = new AvitoParser();
        pars.parsAvito();
    }
}
