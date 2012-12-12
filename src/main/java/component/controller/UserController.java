package component.controller;

import component.service.UserService;
import entity.UserEntity;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Map<String, Object> model) {

        model.put("userList", userService.getAllUsers());
        return "userListView";
    }

    @RequestMapping(value = "/{uid}", method= RequestMethod.GET, produces="text/html")
    public String getUserById(@PathVariable Integer uid, Map<String, Object> model) {

        model.put("userEntity", userService.getById(uid));
        return "showUserProfile";
    }

    /* Api */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody UserEntity apiRegister(@Valid UserEntity userEntity, BindingResult bindingResult, HttpServletRequest request) throws BindException {
        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        else {
            return userService.createNewUserAndAuthenticate(userEntity, request, false);
        }
    }

    @RequestMapping(value="/check", method = RequestMethod.POST)
    @ResponseBody
    public void checkIfAlreadyRegistred(@RequestParam("email") String email, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        if(userService.checkIfExist(email)) {
            response.getWriter().write("alreadyExists");
        }
        else {
            response.getWriter().write("available");
        }
    }
}
