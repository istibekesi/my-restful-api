package model.v3;

import java.util.List;

/**
 * Created by ibekesi on 2014.11.26..
 */
public class Manager {

    private long id;
    private String extension;
    private String description;
    private String callerIdRegex;
    private String callerIdReplace;
    private boolean available;

    private List<Assistant> assistantList;

    public Manager () {

    }

    public Manager(long id, String extension, String description, String callerIdRegex, String callerIdReplace, boolean available, List<Assistant> assistantList) {
        this.id = id;
        this.extension = extension;
        this.description = description;
        this.callerIdRegex = callerIdRegex;
        this.callerIdReplace = callerIdReplace;
        this.available = available;
        this.assistantList = assistantList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCallerIdRegex() {
        return callerIdRegex;
    }

    public void setCallerIdRegex(String callerIdRegex) {
        this.callerIdRegex = callerIdRegex;
    }

    public String getCallerIdReplace() {
        return callerIdReplace;
    }

    public void setCallerIdReplace(String callerIdReplace) {
        this.callerIdReplace = callerIdReplace;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Assistant> getAssistantList() {
        return assistantList;
    }

    public void setAssistantList(List<Assistant> assistantList) {
        this.assistantList = assistantList;
    }
}
