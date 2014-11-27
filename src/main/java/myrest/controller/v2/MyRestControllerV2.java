package myrest.controller.v2;

import model.v2.Assistant;
import model.v2.Manager;
import myrest.MyRestfulApp;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody public List<Manager> managers(){
        return MyRestfulApp.repoV2.getManagers();
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
}
