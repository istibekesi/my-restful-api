package myrest.controller.v3;

import model.v3.Assistant;
import model.v3.Manager;
import myrest.MyRestfulApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API LEVEL : 3 HIPERMEDIA CONTROLS
 */
@Controller
@RequestMapping("/myrest/v3")
public class MyRestControllerV3 {


    private final ManagerResourceAssembler managerResourceAssembler;
    private final AssistantResourceAssembler assistantResourceAssembler;


    @Autowired
    MyRestControllerV3(ManagerResourceAssembler managerResourceAssembler, AssistantResourceAssembler assistantResourceAssembler){
        this.managerResourceAssembler = managerResourceAssembler;
        this.assistantResourceAssembler = assistantResourceAssembler;
    }

    @RequestMapping(
            value = "/managers",
            method = RequestMethod.GET
    )
    @ResponseBody public List<Resource<Manager>> managers(){
        //return MyRestfulApp.repoV3.getManagers();
        return this.managerResourceAssembler.toResource(MyRestfulApp.repoV3.getManagers());
    }

    @RequestMapping(value = "/manager/{id}",
            method = RequestMethod.GET
    )
    @ResponseBody public Resource<Manager> managers(@PathVariable long id){
        //return MyRestfulApp.repoV3.getManagerById(id);
        return this.managerResourceAssembler.toResource(MyRestfulApp.repoV3.getManagerById(id));
    }

/*    @RequestMapping(value = "/assistants",
            method = RequestMethod.GET
    )
    @ResponseBody public List<Resource<Assistant>> assistants(){
        return assistantResourceAssembler.toResource(MyRestfulApp.repoV3.getAssistants());
    }
    */

    @RequestMapping(value = "/assistants",
            method = RequestMethod.GET
    )
    @ResponseBody public List<Resource<Assistant>> assistants(@RequestParam(value = "byManager", required = false, defaultValue = "0") long managerId){
        return assistantResourceAssembler.toResource(MyRestfulApp.repoV3.getAssistantsByManager(managerId));
    }

    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.GET
    )
    @ResponseBody public Resource<Assistant> assistant(@PathVariable long id){
        return assistantResourceAssembler.toResource(MyRestfulApp.repoV3.getAssistantById(id));
    }


    /*
     * POST - CREATE ASSISTANT
     */
    @RequestMapping(value = "/assistant",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public void addAssistant(@RequestBody Assistant assistant) {

        MyRestfulApp.repoV3.generateId(assistant);
        MyRestfulApp.repoV3.addAssistant(assistant);
        return;

    }

    /*
     * PUT - FULL UPDATE ASSISTANT
     */
    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateAssistant(@PathVariable Long id , @RequestBody Assistant assistant) {

        Assistant existingAssitant = MyRestfulApp.repoV3.getAssistantById(id);

        if (existingAssitant == null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        assistant.setId( existingAssitant.getId() );
        MyRestfulApp.repoV3.addAssistant(assistant);

        return new ResponseEntity<String>(HttpStatus.OK);

    }

    /*
    * PATCH - PARTIAL UPDATE ASSISTANT
    */
    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity patchAssistant(@PathVariable Long id , @RequestBody Assistant assistant) {

        Assistant existingAssitant = MyRestfulApp.repoV3.getAssistantById(id);

        if (existingAssitant == null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        if (assistant.getName() != null && !assistant.getName().isEmpty() ){
            existingAssitant.setName(assistant.getName());
        }
        if (assistant.getStatus() != null && !assistant.getStatus().isEmpty() ){
            existingAssitant.setStatus(assistant.getStatus());
        }
        if (assistant.getDescription() != null && !assistant.getDescription().isEmpty() ){
            existingAssitant.setDescription(assistant.getDescription());
        }
        if (assistant.getExtension() != null && !assistant.getExtension().isEmpty() ){
            existingAssitant.setExtension(assistant.getExtension());
        }

        return new ResponseEntity<String>(HttpStatus.OK);

    }

    /*
     * DELETE
    */
    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity updateAssistant(@PathVariable Long id) {

        Assistant existingAssitant = MyRestfulApp.repoV3.getAssistantById(id);

        if (existingAssitant == null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        MyRestfulApp.repoV3.removeAssistant(existingAssitant);

        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
