package myrest.controller.v2;

import model.v2.Assistant;
import model.v2.Manager;
import model.v2.ManagersWrapper;
import myrest.MyRestfulApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API LEVEL : 2 HTTP Verbs
 */
@Controller
@RequestMapping("/myrest/v2")
public class MyRestControllerV2 {


    @RequestMapping(
            value = "/managers",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public ManagersWrapper managers(){
        return new ManagersWrapper(MyRestfulApp.repoV2.getManagers());
    }

    @RequestMapping(value = "/manager/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public Manager managers(@PathVariable long id){
        return MyRestfulApp.repoV2.getManagerById(id);
    }

    @RequestMapping(value = "/assistants",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public List<Assistant> assistants(){
        return MyRestfulApp.repoV2.getAssistants();
    }

    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public Assistant assistants(@PathVariable long id){
        return MyRestfulApp.repoV2.getAssistantById(id);
    }


    /*
     * POST - CREATE ASSISTANT
     */
    @RequestMapping(value = "/assistant",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public void addAssistant(@RequestBody Assistant assistant) {

        MyRestfulApp.repoV2.generateId(assistant);
        MyRestfulApp.repoV2.addAssistant(assistant);
        return;

    }

}
