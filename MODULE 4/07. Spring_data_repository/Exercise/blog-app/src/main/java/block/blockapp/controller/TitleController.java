package block.blockapp.controller;

import block.blockapp.model.Title;
import block.blockapp.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TitleController {
    @Autowired
    ITitleService titleService;

    @GetMapping(value = "/create-title")
    public String showNewFormTitle(Model model){
        model.addAttribute("title",new Title());
        return "/title/create";
    }
    @PostMapping(value = "/create-title")
    public String createTitle(@ModelAttribute Title title, RedirectAttributes redirectAttributes){
        titleService.save(title);
        redirectAttributes.addFlashAttribute("message","A title was created!");
        return "redirect:/titles";
    }

    @GetMapping(value = "/titles")
    public String showListTitles(@PageableDefault(size = 2) Pageable pageable,Model model){
        Page<Title> titles = titleService.findAll(pageable);
        model.addAttribute("titles",titles);
        return "/title/list";
    }

    @GetMapping(value = "/edit-title/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model){
        Optional<Title>  title = titleService.findById(id);
        model.addAttribute("title",title);
        return "/title/edit";
    }

    @PostMapping(value = "/edit-title")
    public String editTitle(@ModelAttribute Title title,RedirectAttributes redirectAttributes){
        titleService.save(title);
        redirectAttributes.addFlashAttribute("message","A title was updated!");
        return "redirect:/titles";
    }

    @GetMapping(value = "/del-title/{id}")
    public String showDelForm(@PathVariable Integer id,Model model){
        Optional<Title>  title = titleService.findById(id);
        model.addAttribute("title",title);
        return "/title/delete";
    }
    @PostMapping(value = "/del-title")
    public String delTitle(@ModelAttribute Title title,RedirectAttributes redirectAttributes){
        titleService.remove(title.getId());
        redirectAttributes.addFlashAttribute("message","A title was deleted!");
        return "redirect:/titles";
    }
}
