package myrest;

import model.Assistant;
import model.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * RESTful API LEVEL : 1 Resources
 *
 */
@Controller
public class MyRestController1 {

    @RequestMapping("/myrest/version")
    @ResponseBody public String version() {
        return "1.0.0";
    }

    @RequestMapping("/myrest/1/managers")
    @ResponseBody public List<Manager> managers(){
        return MyRestfulApp.repo.getManagers();
    }

    @RequestMapping("/myrest/1/manager/{id}")
    @ResponseBody public Manager managers(@PathVariable long id){
        return MyRestfulApp.repo.getManagerById(id);
    }

    @RequestMapping("/myrest/1/assistants")
    @ResponseBody public List<Assistant> assistants(){
        return MyRestfulApp.repo.getAssistants();
    }

    @RequestMapping("/myrest/1/assistant/{id}")
    @ResponseBody public Assistant assistants(@PathVariable long id){
        return MyRestfulApp.repo.getAssistantById(id);
    }
}
