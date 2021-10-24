package pl.samples.Mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by MikBac on 24.10.2021
 */

@Log4j2
public class Main {

    public static void main(String[] args) {
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = mustacheFactory.compile("src/main/java/pl/samples/Mustache/demo.mustache");

        Demo demo = new Demo("Test title", "Test text");

        StringWriter writer = new StringWriter();
        try {
            mustache.execute(writer, demo).flush();
            log.info(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
