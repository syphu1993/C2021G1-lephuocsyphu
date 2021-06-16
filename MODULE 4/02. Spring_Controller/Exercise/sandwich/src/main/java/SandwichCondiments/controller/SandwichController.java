package SandwichCondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = {"/","condiments"})
    public String chooseCondiments(){
        return "home";
    }
    @PostMapping(value = {"/choose"})
    public String sava(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "result";
    }

}
