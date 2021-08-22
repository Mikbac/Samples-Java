package pl.samples.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by MikBac on 02.07.2021
 */

public class Main {

    public static void main(String[] args) {
        Document document = null;

        try {
            document = Jsoup.connect("https://en.wikipedia.org/").get();
        } catch (IOException e) {
            System.out.println("Error connection to the Wikipedia!");
        }

        getTagTitle(document);
        getTagBody(document);
        getAttribute(document);
    }

    private static void getTagTitle(final Document document) {
        System.out.println(document.title());
    }

    private static void getTagBody(final Document document) {
        System.out.println(document.body());
        System.out.println(document.body().className());
    }

    private static void getAttribute(final Document document) {
        Elements newsHeadlines = document.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.println(headline.attr("title"));
            System.out.println(headline.absUrl("href"));
        }
    }

}
