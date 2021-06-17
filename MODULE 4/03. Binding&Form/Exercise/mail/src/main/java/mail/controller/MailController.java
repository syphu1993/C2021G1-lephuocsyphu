package mail.controller;

import mail.model.Mail;
import mail.service.IMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {
    @Autowired
    IMail mailController;
    @GetMapping(value = {"/","/list"})
    public String showAll(Model model){
        model.addAttribute("mails",mailController.findAll());
        return "list-save";
    }
    @GetMapping(value = {"/detail"})
    public String showMail(@RequestParam int id,Model model){
        model.addAttribute("mail",mailController.findById(id));
        return "detail-update";
    }
    @PostMapping(value = {"/update"})
    public String updateMail(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes){
    mailController.update(mail);
    redirectAttributes.addFlashAttribute("msg","A Mail Was Updated!");
    return "redirect:/list";
    }
}
