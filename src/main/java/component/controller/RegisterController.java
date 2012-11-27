package component.controller;

import component.service.UserService;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping({"/rejestracja"})
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegisterPage(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registerPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String formHandler(@Valid UserEntity userEntity, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "registerPage";
        }
        else {
            userService.createNewUserAndAuthenticate(userEntity, request);
            return "redirect:/user/" + userEntity.getId();
        }
    }

}
