package model.v2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ibekesi on 2014.11.26..
 */
@XmlRootElement
public class Assistant {

    private long id;
    private String name;
    private String extension;
    private String description;
    private String status;

    public Assistant(){
        // JAXB needs a default constructor to be present!
    };

    public Assistant(long id, String name, String extension, String description, String status) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.description = description;
        this.status = status;
    }

    @XmlAttribute
    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
