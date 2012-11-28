package component.controller;

import component.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String showProjectList(Map<String, Object> model, Principal principal) {

        model.put("userProjectList", projectService.getProjectsByUser(principal.getName()));
        return "projectDefaultView";
    }
}
