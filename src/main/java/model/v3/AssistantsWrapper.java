package model.v3;

import org.springframework.hateoas.Resource;

import java.util.List;

/**
 * Created by ibekesi on 2014.12.02..
 */
public class AssistantsWrapper {
    List<Resource<Assistant>> assistants;

    public AssistantsWrapper () {}

    public AssistantsWrapper(List<Resource<Assistant>> assistants) {
        this.assistants = assistants;
    }

    public List<Resource<Assistant>> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Resource<Assistant>> assistants) {
        this.assistants = assistants;
    }
}
