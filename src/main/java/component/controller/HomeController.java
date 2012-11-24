package component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
