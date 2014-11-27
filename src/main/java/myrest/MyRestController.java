package myrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}