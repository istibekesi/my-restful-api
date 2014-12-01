package myrest.controller.v3;

import model.v3.Manager;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by ibekesi on 2014.12.01..
 */
@Component
public final class ManagerResourceAssembler implements ResourceAssembler<Manager, Resource<Manager>>{

    @Override
    public Resource<Manager> toResource(Manager manager) {
        Resource<Manager> managerResource = new Resource<Manager>(manager);

        managerResource.add(linkTo(MyRestControllerV3.class).slash("manager").slash(manager.getId()).withSelfRel());
        managerResource.add(linkTo(MyRestControllerV3.class).slash("assistants?byManager="+manager.getId()).withRel("assistants"));

        return managerResource;
    }


    public List<Resource<Manager>> toResource(List<Manager> managers) {
        List<Resource<Manager>> managerResourceList = new ArrayList<Resource<Manager>>();
        if (managers != null) {
            for (Manager m : managers){
                managerResourceList.add(toResource(m));
            }
        }
        return managerResourceList;
    }
}
