package ca.tetervak.hellouser.controller;

import ca.tetervak.hellouser.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloUserController {

    Logger logger = LoggerFactory.getLogger(HelloUserController.class);

    @GetMapping(value={"/","/input"})
    public String input(){
        logger.trace("input() is called");
        return "Input";
    }

    @GetMapping("/output")
    public String output(Model model){
        logger.trace("output() is called");

        User user = new User("Bart", "Simpson");

        int rand = 1 + (int)(100*Math.random());
        logger.debug("rand = " + rand);

        model.addAttribute("user", user);
        model.addAttribute("rand", rand);

        return "Output";
    }

}
