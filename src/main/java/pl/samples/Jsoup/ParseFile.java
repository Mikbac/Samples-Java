package pl.samples.Jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Created by MikBac on 02.07.2021
 */

@Log4j2
public class ParseFile {

    public static void main(String[] args) {
        getDataFromFile();
    }

    private static void getDataFromFile() {
        File input = new File("./src/main/java/pl/samples/Jsoup/example.html");
        try {
            Document doc = Jsoup.parse(input, "UTF-8", "");
            log.info("p tag -> {}", doc.getElementsByTag("p"));
            log.info("p tag -> {}", doc.getElementsByTag("p").text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
