package myrest.v1;

import model.v1.Assistant;
import model.v1.Manager;
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

    @RequestMapping("/managers")
    @ResponseBody public List<Manager> managers(){
        return MyRestfulApp.repo.getManagers();
    }

    @RequestMapping("/manager/{id}")
    @ResponseBody public Manager managers(@PathVariable long id){
        return MyRestfulApp.repo.getManagerById(id);
    }

    @RequestMapping("/assistants")
    @ResponseBody public List<Assistant> assistants(){
        return MyRestfulApp.repo.getAssistants();
    }

    @RequestMapping("/assistant/{id}")
    @ResponseBody public Assistant assistants(@PathVariable long id){
        return MyRestfulApp.repo.getAssistantById(id);
    }
}
