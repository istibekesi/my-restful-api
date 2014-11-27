package myrest.controller.v1;

import model.v2.Assistant;
import model.v2.Manager;
import myrest.MyRestfulApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * RESTful API LEVEL : 1 Resources
 */
@Controller
@RequestMapping("/myrest/v1")
public class MyRestControllerV1 {

    @RequestMapping( value = "/managers" )
    @ResponseBody public List<Manager> managers(){
        return MyRestfulApp.repoV2.getManagers();
    }

    @RequestMapping(value = "/manager/{id}" )
    @ResponseBody public Manager managers(@PathVariable long id){
        return MyRestfulApp.repoV2.getManagerById(id);
    }

    @RequestMapping(value = "/assistants" )
    @ResponseBody public List<Assistant> assistants(){
        return MyRestfulApp.repoV2.getAssistants();
    }

    @RequestMapping(value = "/assistant/{id}" )
    @ResponseBody public Assistant assistants(@PathVariable long id){
        return MyRestfulApp.repoV2.getAssistantById(id);
    }
}
