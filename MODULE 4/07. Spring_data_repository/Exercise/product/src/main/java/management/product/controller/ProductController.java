package management.product.controller;

import management.product.model.Product;
import management.product.model.Type;
import management.product.service.IProductService;
import management.product.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeService typeService;

    @ModelAttribute("types")
    public Page<Type> showListType(Pageable pageable){
        return typeService.findAll(pageable);
    }

    @GetMapping(value = "/create-product")
    public String showNewForm(Model model){
       model.addAttribute("product",new Product());
       return "product/create";
    }
    @PostMapping(value = "/create-product")
    public String createProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","A product was created!");
        return "redirect:/list";
    }

    @GetMapping(value = "/list")
    public String showList(@PageableDefault(size = 2) Pageable pageable,Model model){
    Page<Product> products = productService.findAll(pageable);
    model.addAttribute("products",products);
    return "product/list";
    }

    @GetMapping(value = "/edit-product/{id}")
    public String showFormEdit(@PathVariable Integer id,Model model){
    Optional<Product> product = productService.findById(id);
    model.addAttribute("product",product);
    return "product/edit";
    }
    @PostMapping(value = "/edit-product")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","A product was updated!");
        return "redirect:/list";
    }

    @GetMapping("/show-product/{id}")
    public String showInfor(@PathVariable Integer id,Model model){
        Optional<Product> product= productService.findById(id);
        model.addAttribute("product",product);
        return "product/show";
    }

    @GetMapping(value = "/del-product/{id}")
    public String showFormDel(@PathVariable Integer id,Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/delete";
    }
    @PostMapping(value = "/del-product")
    public String delProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","A product was deleted!");
        return "redirect:/list";
    }

}
