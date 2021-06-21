package picture.of.day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import picture.of.day.model.entity.ImgOfDay;
import picture.of.day.model.repository.IPictureOfDay;

@Controller
@RequestMapping(value = "")
public class ImgController {
    @Autowired
    IPictureOfDay pictureOfDay;

   @GetMapping(value = {"/img"})
    public String showHome(Model model){
       model.addAttribute("img", new ImgOfDay());
       model.addAttribute("list", pictureOfDay.findAll());
       return "home";
   }
   @PostMapping(value = "/save")
    public String saveImg(@ModelAttribute ImgOfDay img){
       pictureOfDay.save(img);
       return "redirect:/img";
   }

   @GetMapping(value = {"/like/{id}"})
    public String likes(@PathVariable int id){
       ImgOfDay img = pictureOfDay.findOne(id);
       img.setLikes(img.getLikes()+1);
       pictureOfDay.update(img);
       return "redirect:/img";
   }
}
