package model.v1;

/**
 * Created by ibekesi on 2014.11.26..
 */
public class Assistant {

    private long id;
    private String name;
    private String extension;
    private String description;
    private String status;

    public Assistant(long id, String name, String extension, String description, String status) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.description = description;
        this.status = status;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
