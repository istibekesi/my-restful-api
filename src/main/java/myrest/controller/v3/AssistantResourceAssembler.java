package myrest.controller.v3;

import model.v3.Assistant;
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
public final class AssistantResourceAssembler implements ResourceAssembler<Assistant, Resource<Assistant>>{

    @Override
    public Resource<Assistant> toResource(Assistant assistant) {
        Resource<Assistant> assistantResource = new Resource<Assistant>(assistant);

        //assistantResource.add(linkTo(GamesController.class).slash(game.getId()).slash("doors").withRel("doors"));
        //assistantResource.add(linkTo(GamesController.class).slash(game.getId()).withSelfRel());

        assistantResource.add(linkTo(MyRestControllerV3.class).slash("assistant").slash(assistant.getId()).withSelfRel());

        return assistantResource;
    }


    public List<Resource<Assistant>> toResource(List<Assistant> assistants) {
        List<Resource<Assistant>> assistantResourceList = new ArrayList<Resource<Assistant>>();
        if (assistants!= null) {
            for (Assistant m : assistants){
                assistantResourceList.add(toResource(m));
            }
        }
        return assistantResourceList;
    }
}
