package myrest.controller.v2;

import model.v2.Assistant;
import model.v2.Manager;
import model.v2.ManagersWrapper;
import myrest.MyRestfulApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    /*
     * PUT - FULL UPDATE ASSISTANT
     */
    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateAssistant(@PathVariable Long id , @RequestBody Assistant assistant) {

        Assistant existingAssitant = MyRestfulApp.repoV2.getAssistantById(id);

        if (existingAssitant == null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        assistant.setId( existingAssitant.getId() );
        MyRestfulApp.repoV2.addAssistant(assistant);

        return new ResponseEntity<String>(HttpStatus.OK);

    }

    /*
    * PATCH - PARTIAL UPDATE ASSISTANT
    */
    @RequestMapping(value = "/assistant/{id}",
            method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity patchAssistant(@PathVariable Long id , @RequestBody Assistant assistant) {

        Assistant existingAssitant = MyRestfulApp.repoV2.getAssistantById(id);

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

        Assistant existingAssitant = MyRestfulApp.repoV2.getAssistantById(id);

        if (existingAssitant == null) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        MyRestfulApp.repoV2.removeAssistant(existingAssitant);

        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
