package project.furama.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.furama.dto.CustomerDto;
import project.furama.model.Customer;
import project.furama.model.Employee;
import project.furama.model.TypeCustomer;
import project.furama.service.CustomerService;
import project.furama.service.TypeCustomerService;

import javax.validation.Valid;
import java.util.Optional;

@Controller

public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private TypeCustomerService typeCustomerService;

    @GetMapping(value = {"/home"})
    public String showHomePage(){
        return "home/index";
    }

    @ModelAttribute("listType")
    public Iterable<TypeCustomer> showType(){
        return typeCustomerService.findAll();
    }

    @GetMapping(value = "/customer")
    public String showListCustomer(@PageableDefault(size = 5) Pageable pageable,
                                   @RequestParam Optional<String> keyName, @RequestParam Optional<String> typeOfCustomer,
                                   Model model){
        String keyValue ="";
        String keyTypeValue ="";
        if (keyName.isPresent()){
            keyValue=keyName.get();
        }
        if (typeOfCustomer.isPresent()){
            keyTypeValue=typeOfCustomer.get();
        }
        Page<Customer> customers = customerService.findAllByName(pageable,keyValue,keyTypeValue);
        model.addAttribute("keyValue",keyValue);
        model.addAttribute("keyTypeValue",keyTypeValue);
        model.addAttribute("customers",customers);
        return "customer/list";
    }

    @GetMapping(value = "/create-customer")
    public String showFormCreate(Model  model){
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }
    @PostMapping(value = "/create-customer")
    public String createCustomer(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setFlag(1);
        this.customerService.save(customer);
        model.addAttribute("message","A customer was created!");
        return "customer/create";
    }

    @GetMapping(value = "/edit-customer/{id}")
    public String showFormEdit(@PathVariable Integer id,Model model){
        Optional<Customer> customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }

    @PostMapping(value = "/edit-customer")
    public String editCustomer(@ModelAttribute CustomerDto customerDto,Model model){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        this.customerService.save(customer);
        model.addAttribute("message","A customer was updated!");
        return "customer/edit";
    }
    @PostMapping(value = "/del-customer")
    public String  delCustomer(@RequestParam Integer  id){
        Optional<Customer> customer = customerService.findById(id);
        customer.get().setFlag(0);
        this.customerService.save(customer.get());
        return "redirect:/customer";
    }

    @GetMapping(value = "/show-customer/{id}")
    public String showInforCustomer(@PathVariable Integer id,Model model){
        Optional<Customer> customer = this.customerService.findById(id);
        model.addAttribute("customer",customer.get());
        return "customer/show";
    }


}
