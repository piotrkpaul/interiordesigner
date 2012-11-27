package component.controller;

import component.service.UserService;
import entity.UserEntity;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{uid}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public UserEntity restListUsers(@PathVariable Integer uid) {
        return userService.getById(uid);

    }

    @RequestMapping(value = "/uid}", method= RequestMethod.GET)
    public String getUserById(@PathVariable Integer uid, Map<String, Object> model) {

        model.put("userEntity", userService.getById(uid));

        return "userView";
    }



}
