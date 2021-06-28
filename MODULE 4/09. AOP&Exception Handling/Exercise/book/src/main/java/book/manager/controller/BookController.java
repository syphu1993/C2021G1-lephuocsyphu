package book.manager.controller;

import book.manager.model.Book;
import book.manager.model.BorowBook;
import book.manager.service.IBookService;
import book.manager.service.IBorowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorowBook borowBookService;

    @GetMapping(value = "/create-book")
    public String showFormCreateBook(Model model){
        model.addAttribute("book",new Book());
        return "book/create";
    }
    @PostMapping(value = "/create-book")
    public String createBook(@ModelAttribute Book book){
        bookService.save(book);
        return "book/create";
    }

    @GetMapping(value = "/home")
    public String showHome(Model model){
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book/list";
    }

    @GetMapping(value = "/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Optional<Book> book=bookService.findById(id);
        BorowBook borowBook = new BorowBook();
        int codeBook = (int) (Math.random()*100000);
        borowBook.setCodeBook(codeBook);
        borowBook.setBook(book.get());
        borowBookService.save(borowBook);
        book.get().setQuantity(book.get().getQuantity()-1);
        bookService.save(book.get());
        redirectAttributes.addFlashAttribute("note","Code borrow :"+codeBook);
        return "redirect:/home";
    }

    @GetMapping(value = "/return/{id}")
    public String showDetaiBook(@PathVariable Integer id, Model model){
    Optional<Book> book = bookService.findById(id);
    model.addAttribute("book",book);
    return "book/return";
    }

}
