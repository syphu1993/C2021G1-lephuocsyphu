package caculator.controller;

import caculator.service.ICaculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculator caculator;
    @GetMapping(value = {"/","/caculator"})
    public String formCauclator(){
        return "form";
    }
    @PostMapping(value = {"/act"})
    public String caculate(@RequestParam double a, @RequestParam double b, @RequestParam String operate, Model model){
        model.addAttribute("result",caculator.caculate(a,b,operate));
        return "form";
    }
}
