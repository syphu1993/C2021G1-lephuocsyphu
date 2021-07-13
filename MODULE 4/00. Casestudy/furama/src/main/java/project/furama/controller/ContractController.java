package project.furama.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.furama.dto.ContractDto;
import project.furama.model.Contract;
import project.furama.model.Customer;
import project.furama.model.Employee;
import project.furama.model.Service;
import project.furama.service.IContractService;
import project.furama.service.ICustomerService;
import project.furama.service.IEmployeeService;
import project.furama.service.IServiceService;

import javax.validation.Valid;

@Controller
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;

    @ModelAttribute("employees")
    public Iterable<Employee> showListEmloyee(){
        return employeeService.findAllNoPage();
    }
    @ModelAttribute("customers")
    public Iterable<Customer> showListCustomer(){
        return customerService.findAllNoPage();
    }
    @ModelAttribute("services")
    public Iterable<Service> showListService(){
        return serviceService.findAll();
    }
    @GetMapping(value = "/contract")
    public String showListContract(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Contract> contracts = contractService.findAllByPage(pageable);
        model.addAttribute("contracts",contracts);
        return "contract/list";
    }
    @GetMapping(value = "/create-contract")
    public String showFormCreateContract(Model model){
        model.addAttribute("contractDto", new ContractDto());
        return "contract/create";
    }
    @PostMapping(value = "/create-contract")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setFlag(1);
        this.contractService.save(contract);
        model.addAttribute("message","A contract was created!");
        return "contract/create";
    }
}
