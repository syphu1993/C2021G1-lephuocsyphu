package user.infor.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import user.infor.dto.UserDto;
import user.infor.model.User;
import user.infor.service.IUserService;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/")
    public String showNewForm(Model model){
        model.addAttribute("userDato",new UserDto());
        return "/create_user";
    }
//    @PostMapping(value = "/create")
//    public String createUser(@ModelAttribute User user,Model model){
//        userService.save(user);
//        return "create";
//    }
    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute @Valid UserDto userDto,
                             BindingResult bindingResult){
//        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create_user";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        this.userService.save(user);
        return "result";
    }
}
