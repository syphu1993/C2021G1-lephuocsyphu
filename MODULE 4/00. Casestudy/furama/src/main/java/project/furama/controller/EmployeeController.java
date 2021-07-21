package project.furama.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.furama.dto.EmployeeDto;
import project.furama.model.*;
import project.furama.service.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDegreeService degreeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IUserService userService;

    @ModelAttribute("positions")
    public Iterable<Position> ShowListPosition(){
        return positionService.findAll();
    }
    @ModelAttribute("degrees")
    public Iterable<Degree> ShowListDegree(){
        return degreeService.findAll();
    }
    @ModelAttribute("divisions")
    public Iterable<Division> ShowListDivision(){
        return divisionService.findAll();
    }

    @GetMapping(value = "/employee")
    public String showListEmployee(@PageableDefault(size = 5) Pageable pageable,
                                   @RequestParam Optional<String> key,
                                   Model model){
        String keyValue ="";
        if (key.isPresent()){
            keyValue=key.get();
        }
        Page<Employee> employees = employeeService.findAllByName(pageable,keyValue);
        model.addAttribute("keyValue",keyValue);
        model.addAttribute("employees",employees);
        return "employee/list";
    }
    @GetMapping(value = "/create-employee")
    public String showFormCreate(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        return "employee/create";
    }
    @PostMapping(value = "/create-employee")
    public String createEmployee(@ModelAttribute @Valid EmployeeDto employeeDto, BindingResult bindingResult, @RequestParam String userName, Model model){
        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        AppUser user = new AppUser();
        user.setUserName(userName);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passWord = bCryptPasswordEncoder.encode("123456");
        System.out.println(passWord);
        user.setPassWord(passWord);
        this.userService.save(user);
        employeeDto.setUser(user);
        employeeDto.setFlag(1);
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.employeeService.save(employee);
        model.addAttribute("message","A employee was created!");
        return "employee/create";
    }
    @GetMapping(value = "/edit-employee/{id}")
    public String showFormEdit(@PathVariable Integer id,Model model){
       Optional<Employee> employee = this.employeeService.findById(id);
       EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(),employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }
    @PostMapping(value = "/edit-employee")
    public String editEmployee(@ModelAttribute EmployeeDto employeeDto,@RequestParam String userNameNew,@RequestParam String userNameOld, Model model){
        AppUser user = new AppUser();
        user.setUserName(userNameNew);
        user.setPassWord(String.valueOf(Math.random()*10000));
        this.userService.save(user);
        employeeDto.setUser(user);
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setFlag(1);
        this.employeeService.save(employee);
        this.userService.delete(userNameOld);
        model.addAttribute("message","A employee was updated!");
        return "employee/edit";
    }

    @GetMapping(value = "/del-employee")
    public String delEmployee(@RequestParam Integer id){
        Optional<Employee> employee = this.employeeService.findById(id);
        employee.get().setFlag(0);
        this.employeeService.save(employee.get());
        return "redirect:/employee";
    }

}
