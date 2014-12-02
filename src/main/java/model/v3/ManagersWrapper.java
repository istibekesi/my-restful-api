package model.v3;

import org.springframework.hateoas.Resource;

import java.util.List;

/**
 * Created by ibekesi on 2014.12.02..
 */
public class ManagersWrapper {
    List<Resource<Manager>> managers;

    public ManagersWrapper () {}

    public ManagersWrapper(List<Resource<Manager>> managers) {
        this.managers = managers;
    }

    public List<Resource<Manager>> getManagers() {
        return managers;
    }

    public void setManagers(List<Resource<Manager>> managers) {
        this.managers = managers;
    }
}