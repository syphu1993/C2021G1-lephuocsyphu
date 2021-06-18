package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.model.Product;
import product.service.Iproduct;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    Iproduct iproduct;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = iproduct.findAll();
        model.addAttribute("products", products);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        iproduct.save(product);
        redirectAttributes.addFlashAttribute("msg","A product was created!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iproduct.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        iproduct.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("msg","A product was updated!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iproduct.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iproduct.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iproduct.findById(id));
        return "/view";
    }

}
