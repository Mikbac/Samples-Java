package pl.samples.Jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by MikBac on 02.07.2021
 */

@Log4j2
public class ParseUrl {

    public static void main(String[] args) {
        Document document = null;

        try {
            document = Jsoup.connect("https://en.wikipedia.org/").get();
        } catch (IOException e) {
            log.info("Error connection to the Wikipedia!");
        }

        getTagTitle(document);
        getTagBody(document);
        getAttribute(document);
    }

    private static void getTagTitle(final Document document) {
        log.info("Document title -> {}", document.title());
    }

    private static void getTagBody(final Document document) {
        log.info("Document body -> {}", document.body());
        log.info("Document body className -> {}", document.body().className());
    }

    private static void getAttribute(final Document document) {
        Elements newsHeadlines = document.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log.info("Selector attribute title -> {}", headline.attr("title"));
            log.info("Selector attribute href -> {}", headline.absUrl("href"));
        }
    }

}
