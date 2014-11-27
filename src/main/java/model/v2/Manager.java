package model.v2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ibekesi on 2014.11.26..
 */
@XmlRootElement
public class Manager {

    private long id;
    private String extension;
    private String description;
    private String callerIdRegex;
    private String callerIdReplace;
    private boolean available;

    private List<Assistant> assistantList;

    public Manager(){
        // JAXB needs a default constructor to be present!
    };

    public Manager(long id, String extension, String description, String callerIdRegex, String callerIdReplace, boolean available, List<Assistant> assistantList) {
        this.id = id;
        this.extension = extension;
        this.description = description;
        this.callerIdRegex = callerIdRegex;
        this.callerIdReplace = callerIdReplace;
        this.available = available;
        this.assistantList = assistantList;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public String getCallerIdRegex() {
        return callerIdRegex;
    }

    public void setCallerIdRegex(String callerIdRegex) {
        this.callerIdRegex = callerIdRegex;
    }

    @XmlElement
    public String getCallerIdReplace() {
        return callerIdReplace;
    }

    public void setCallerIdReplace(String callerIdReplace) {
        this.callerIdReplace = callerIdReplace;
    }

    @XmlElement
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @XmlElement
    public List<Assistant> getAssistantList() {
        return assistantList;
    }

    public void setAssistantList(List<Assistant> assistantList) {
        this.assistantList = assistantList;
    }
}
