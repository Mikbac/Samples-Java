package pl.samples.JAXB.Serialization;

import lombok.extern.log4j.Log4j2;
import pl.samples.JAXB.Model.Root;
import pl.samples.JAXB.Model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikBac on 19.09.2021
 */

@Log4j2
public class Main {

    private static final String PATH = "src/main/java/pl/samples/JAXB/Serialization/users.xml";

    public static void main(String[] args) {
        try {

            JAXBContext ctx = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            List<User> userList = new ArrayList<>();
            User userOne = new User("u1", "Alice", "Ecila");
            User userTwo = new User("u2", "Bob", "Bob");

            userList.add(userOne);
            userList.add(userTwo);

            Root root = new Root("v1", userList);

            marshaller.marshal(root, new File(PATH));
        } catch (JAXBException e) {
            log.error(e);
        }

    }

}
