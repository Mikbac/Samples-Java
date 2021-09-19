package pl.samples.JAXB.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by MikBac on 19.09.2021
 */

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    private String version;
    private List<User> userList;

    public Root() {
    }

    public Root(final String version, final List<User> userList) {
        this.version = version;
        this.userList = userList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(final List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Root{" +
                "version='" + version + '\'' +
                ", users=" + userList +
                '}';
    }
}
