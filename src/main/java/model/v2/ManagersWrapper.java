package model.v2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ibekesi on 2014.11.28..
 */
@XmlRootElement
public class ManagersWrapper {
    private List<Manager> managers;

    public ManagersWrapper() {
    }

    public ManagersWrapper(List<Manager> managers) {
        this.managers = managers;
    }

    @XmlElement
    public List<Manager> getManagers() {

        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }
}
