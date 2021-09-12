package pl.samples.iText;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by MikBac on 12.09.2021
 */

public class Main {

    private static final String PATH = "src/main/java/pl/samples/iText/example.pdf";

    private static final String HTML = "<h1>AAA</h1>"
            + "<h2>aaa</h2>"
            + "<p>aaa</p>"
            + "<h2>aaa</h2>"
            + "<p style='color:red'>bbb</p>"
            + "<a href='google.com'>Google</a>";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        HtmlConverter.convertToPdf(HTML, new FileOutputStream(PATH));
    }

}
