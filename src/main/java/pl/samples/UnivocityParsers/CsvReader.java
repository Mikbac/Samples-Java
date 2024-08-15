package pl.samples.UnivocityParsers;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by MikBac on 22.10.2022
 */

@Log4j2
public class CsvReader {

    private static final String CSV_PATH = "src/main/java/pl/samples/UnivocityParsers/sample.csv";

    public static void main(String[] args) {
        try (Reader inputReader = new InputStreamReader(new FileInputStream((CSV_PATH)), StandardCharsets.UTF_8)) {
            CsvParserSettings config = new CsvParserSettings();
            config.setDelimiterDetectionEnabled(true);

            CsvParser parser = new CsvParser(config);
            List<String[]> parsedRows = parser.parseAll(inputReader);

            // Print first column
            parsedRows.forEach(t -> log.info(t[0]));
        } catch (IOException e) {
            // handle exception
        }
    }

}
