package myrest.repo;

import model.v2.Assistant;
import model.v2.Manager;

import java.util.*;

/**
 * This is the repository we actually store the model objects for the demo application
 *
 * (No database, this is the in memory repo)
 *
 * Created by ibekesi on 2014.11.26..
 */
public class InMemoryModelRepositoryV2 {

    private final Map<Long, Manager> managers = new HashMap<Long, Manager>();
    private final Map<Long, Assistant> assistants = new HashMap<Long, Assistant>();


    public void addManager(Manager manager) {
        managers.put( manager.getId(), manager );
    }

    public void removeManager(Manager manager) {
        managers.remove(manager.getId());
    }

    public List<Manager> getManagers() {
        return new ArrayList(managers.values());
    }

    public Manager getManagerById(long id) {
        return managers.get(id);
    }

    public void addAssistant(Assistant assistant) {
        assistants.put( assistant.getId(), assistant );
    }

    public void removeAssistant(Assistant assistant) {
        assistants.remove(assistant.getId());
    }

    public List<Assistant> getAssistants() {
        return new ArrayList(assistants.values());
    }

    public Assistant getAssistantById(long id) {
        return assistants.get(id);
    }


    public void addAssistants(List<Assistant> assistList) {
        if (assistList != null && !assistList.isEmpty()) {
            for (Assistant a : assistList) {
                addAssistant(a);
            }
        }
    }

    public void generateId(Assistant assistant) {
        // Fake id generator, just for demo
        // Generates random ids as long as finds a free assistant id
        for (int i = 0; i < 10000 ; i++) {
            Random rand = new Random();
            int randomId = rand.nextInt(100);
            if (getAssistantById(randomId) == null) {
                assistant.setId(randomId);
                System.out.println("Generated random id for " + assistant.getName() + " : " + randomId);
                return;
            }
        }

    }
}
