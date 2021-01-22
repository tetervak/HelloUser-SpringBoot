package ca.tetervak.hellouser.controller;

import ca.tetervak.hellouser.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloUserController {

    Logger logger = LoggerFactory.getLogger(HelloUserController.class);


    @GetMapping(value={"/","/Input"})
    public String input(){
        return "Input";
    }

    @GetMapping("/Output")
    public String output(
            Model model,
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        logger.trace("output() is called");

        User user = new User(firstName, lastName);

        int rand = 1 + (int)(100*Math.random());
        logger.debug("rand = " + rand);

        model.addAttribute("user", user);
        model.addAttribute("rand", rand);

        return "Output";
    }

}
