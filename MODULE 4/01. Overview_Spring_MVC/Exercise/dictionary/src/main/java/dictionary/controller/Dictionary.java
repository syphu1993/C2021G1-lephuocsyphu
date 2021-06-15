package dictionary.controller;

import dictionary.service.ITranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @Autowired
    private ITranslation translation;

    @GetMapping(value = {"/","/translate"})
    public String transtale(){
        return "dictionary";
    }

    @PostMapping(value = {"/translate"})
    public String resultTranslation(@RequestParam String english, Model model){
        model.addAttribute("result",translation.translate(english));
        return "result";
    }
}
