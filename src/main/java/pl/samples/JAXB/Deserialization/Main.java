package pl.samples.JAXB.Deserialization;

import lombok.extern.log4j.Log4j2;
import pl.samples.JAXB.Model.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by MikBac on 19.09.2021
 */

@Log4j2
public class Main {

    private static final String PATH = "src/main/java/pl/samples/JAXB/Deserialization/users.xml";

    public static void main(String[] args) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();

            Root root = (Root) unmarshaller.unmarshal(new File(PATH));
            log.info(root);
        } catch (JAXBException e) {
            log.error(e);
        }

    }
}
