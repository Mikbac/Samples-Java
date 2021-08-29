package pl.samples.Jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by MikBac on 02.07.2021
 */

@Log4j2
public class ParseString {

    public static void main(String[] args) {
        getStringParsing();
    }

    private static void getStringParsing() {
        String html = "<div><p>aaa</p></div>";
        Document doc = Jsoup.parseBodyFragment(html);
        log.info("String p tag -> {}", doc.getElementsByTag("p"));
    }

}
