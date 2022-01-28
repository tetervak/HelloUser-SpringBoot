package ca.tetervak.hellouser.controller;

import ca.tetervak.hellouser.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloUserController {

    Logger logger = LoggerFactory.getLogger(HelloUserController.class);


    @GetMapping(value={"/","/Input"})
    public String input(Model model){
        model.addAttribute("user", new User());
        return "Input";
    }

    @GetMapping("/Output")
    public String output(
            Model model,
            @Validated @ModelAttribute User user,
            BindingResult bindingResult
    ){
        logger.trace("output() is called");

        if(bindingResult.hasErrors()){
            return "Input";
        }

        int rand = 1 + (int)(100*Math.random());
        logger.debug("rand = " + rand);

        logger.debug("user = " + user);

        model.addAttribute("user", user);
        model.addAttribute("rand", rand);

        return "Output";
    }

}
