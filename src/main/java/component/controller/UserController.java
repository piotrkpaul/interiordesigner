package component.controller;

import component.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Map<String, Object> model) {

        model.put("userList", userService.getAllUsers());
        return "userView";

    }

    @RequestMapping(value = "/{uid}", method= RequestMethod.GET)
    public String getUserById(@PathVariable String uid, Map<String, Object> model) {

        Integer userId = Integer.parseInt(uid);
        model.put("userEntity", userService.getById(userId));

        return "user/display";
    }

}
