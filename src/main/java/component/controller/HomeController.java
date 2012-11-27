package component.controller;

import entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Date: 07.11.2012
 * Time: 18:58
 */

@Controller
public class HomeController {

    @RequestMapping({"/", "home"})
    public String showHomePage(Map<String, Object> model) {
        return "homeScreen";
    }

    @RequestMapping({"/logowanie"})
    public String showLoginPage(Map<String, Object> model) {
        return "loginPage";
    }
}
