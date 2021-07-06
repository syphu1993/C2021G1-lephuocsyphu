package project.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CustomerController {
    @GetMapping(value = {"/","/home"})
    public String showHomePage(){
        return "home/index";
    }
}
