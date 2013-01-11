package component.controller;

import component.service.UserService;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

/**
 * Date: 07.11.2012
 * Time: 18:58
 */

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/"})
    public String showHomePage(Map<String, Object> model) {
        return "homeScreen";
    }

    @RequestMapping({"/api"})
    public String apiDocumentation(Map<String, Object> model) {
        model.put("pageHeading", "RESTful API");
        model.put("pageLead", "Dokumentacja webapi naszej aplikacji");
        return "apiDocs";
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping({"/logowanie"})
    public String showLoginPage(Map<String, Object> model) {
        return "loginPage";
    }

    /* RESTful custom authorisation */
    @RequestMapping(value="/logowanie", method = RequestMethod.POST)
    @ResponseBody
    public Object apiAuthorize(@RequestParam("username") String email, @RequestParam("password") String password) {
        UserEntity user = userService.getCredentials(email, password);

        if(user.getEmail()!=null) {
            return user;
        } else {
            return "WrongCredentionals";
        }
    }
    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public String showRegisterPage(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registerPage";
    }
    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/rejestracja", method = RequestMethod.POST)
    public String formHandler(@Valid UserEntity userEntity, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "registerPage";
        }
        else {
            userService.createNewUserAndAuthenticate(userEntity, request, true);
            return "redirect:/user/" + userEntity.getId();
        }
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/moje-konto", method = RequestMethod.GET)
    public String showEditForm(Map<String, Object> model, Principal principal) {
        model.put("userEntity", userService.getByEmail(principal.getName()));
        return "editProfilePage";
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/moje-konto", method = RequestMethod.POST)
    public String updateUser(@Valid UserEntity userEntity, BindingResult bindingResult,  Principal principal, HttpServletRequest request) {

        if(bindingResult.hasErrors()) {
            return "registerPage";
        }
        else {

            UserEntity userBeforeEdit = userService.getByEmail(principal.getName());

            userBeforeEdit.setName(userEntity.getName());
            userBeforeEdit.setSurname(userEntity.getSurname());
            userBeforeEdit.setEmail(userEntity.getEmail());
            userBeforeEdit.setPassword(userEntity.getPassword());

            userService.updateUser(userBeforeEdit, request);
            return "redirect:/user/" + userBeforeEdit.getId();
        }
    }
}
