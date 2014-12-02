package myrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ibekesi on 2014.11.27..
 */
@Controller
@RequestMapping("/myrest")
public class MyRestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Welcome - My RESTful API is up and running!";
    }

/*
    @RequestMapping(value="/hal-browser", method= RequestMethod.GET)
    public String halBrowser() {
        return "hal-browser/browser";
    }

    @RequestMapping(value="/x", method= RequestMethod.GET)
    public String index() {
        return "index";
    }
*/

}