package pl.samples.ApacheTika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by MikBac on 05.01.2025
 */
public class Main {

    public static void main(final String[] args) {

        try {
            pdfExample();
        } catch (IOException | TikaException | SAXException e) {
            throw new RuntimeException(e);
        }

    }

    private static void pdfExample() throws IOException, TikaException, SAXException {
        final FileInputStream inputstream = new FileInputStream("src/main/java/pl/samples/ApacheTika/bitcoin.pdf");

        // parse PDF
        final BodyContentHandler bodyContentHandler = new BodyContentHandler();
        final Metadata metadata = new Metadata();
        final PDFParser pdfparser = new PDFParser();
        final ParseContext parseContext = new ParseContext();
        pdfparser.parse(inputstream, bodyContentHandler, metadata, parseContext);

        // PDF content
        System.out.println("Content:" + bodyContentHandler);

        // PDF metadata
        System.out.println("Metadata:");
        Arrays.stream(metadata.names())
                .forEach(n -> System.out.println(n + " : " + metadata.get(n)));

    }

}
