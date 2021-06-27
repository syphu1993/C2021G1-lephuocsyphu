package management.product.controller;

import management.product.model.Type;
import management.product.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TypeController {
    @Autowired
    private ITypeService  typeService;
    @GetMapping(value = "/create-type")
    public String showNewFormType(Model model){
        model.addAttribute("type",new Type());
        return "type/create";
    }
    @PostMapping(value = "/create-type")
    public String createType(@ModelAttribute Type type,Model model){
        typeService.save(type);
        model.addAttribute("messege","A type was created!");
        return "type/create";
    }
}
