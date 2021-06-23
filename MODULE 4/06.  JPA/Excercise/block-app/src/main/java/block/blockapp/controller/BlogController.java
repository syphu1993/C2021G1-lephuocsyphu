package block.blockapp.controller;

import block.blockapp.model.Blog;
import block.blockapp.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping(value = {"/create-blog"})
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }
    @PostMapping(value = {"/create-blog"})
    public String createBlog(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("blog",new Blog());
        model.addAttribute("message","A blog was created!");
        return "/blog/create";
    }

   @GetMapping(value = {"/list"})
    public String showListBlog(Model model){
        Iterable<Blog> blogs=blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "/blog/list";
   }

   @GetMapping(value = {"/show-blog/{id}"})
    public String showContentBlog(@PathVariable Integer id, Model  model){
       Optional<Blog> blog = blogService.findById(id);
       model.addAttribute("blog",blog);
       return "/blog/show";
   }

   @GetMapping(value = {"/edit-blog/{id}"})
    public String showFormEditBlog(@PathVariable Integer id,Model model){
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit";
   }

   @PostMapping(value = {"/edit-blog"})
    public String updateBlog(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","A Blog Was Updated!");
        return "redirect:/list";
   }

   @GetMapping(value = {"/del-blog/{id}"})
   public String showFormDelBlog(@PathVariable Integer id,Model model){
       Optional<Blog> blog = blogService.findById(id);
       model.addAttribute("blog",blog);
       return "/blog/delete";
    }
    @PostMapping(value = {"/del-blog"})
    public String delBlog(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message","A Blog Was deleted!");
        return "redirect:/list";
    }

}
