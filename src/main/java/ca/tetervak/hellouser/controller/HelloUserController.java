package ca.tetervak.hellouser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloUserController {

    Logger logger = LoggerFactory.getLogger(HelloUserController.class);

    @GetMapping(value={"/","/output"})
    public String output(){
        logger.trace("output() is called");
        return "Output";
    }

}
