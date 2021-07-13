package project.furama.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.furama.dto.ServiceDto;
import project.furama.model.RentType;
import project.furama.model.Service;
import project.furama.model.ServiceType;
import project.furama.repository.ServiceRepository;
import project.furama.service.RentTypeService;
import project.furama.service.ServiceService;
import project.furama.service.ServiceTypeService;

import javax.validation.Valid;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceTypeService serviceTypeService;

    @ModelAttribute("typeServices")
    public Iterable<ServiceType> showListTypeService(){
        return serviceTypeService.findAll();
    }
    @ModelAttribute("typeRents")
    public Iterable<RentType> showListTypeRent(){
        return rentTypeService.findAll();
    }

    @GetMapping(value = "/service")
    public String showListService(Model model){
        model.addAttribute("services",serviceService.findAll());
        return "service/list";
    }
    @GetMapping(value = "/create-service")
    public String showNewForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
       return "service/create";
    }
    @PostMapping(value = "/create-service")
    public String createService(@ModelAttribute @Valid ServiceDto serviceDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        this.serviceService.save(service);
        model.addAttribute("message","A service was created!");
        return "service/create";
    }
}
