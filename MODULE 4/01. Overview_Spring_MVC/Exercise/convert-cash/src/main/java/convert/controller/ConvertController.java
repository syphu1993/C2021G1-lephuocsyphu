package convert.controller;

import convert.service.IConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvert convert;
    @GetMapping(value = {"/","/convert"})
    public String  convert(){
        return "form_convert";
    }
    @PostMapping(value = {"/convertCash"})
    public String convertUSDToVND(@RequestParam double usd, @RequestParam double rate, Model model){
        model.addAttribute("result",convert.convertCash(usd,rate));
        return "result";
    }
}
