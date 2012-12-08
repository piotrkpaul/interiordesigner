package component.controller;

import component.service.ProjectService;
import entity.ProjectDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.GET)
    public String showProjectList(Map<String, Object> model, Principal principal) {

        model.put("userProjectList", projectService.getProjectsByUser(principal.getName()));
        return "projectDefaultView";
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showProject(@RequestParam("id") int id, Map<String, Object> model, Principal principall) {
        ProjectDataEntity projectData = projectService.getProject(id);
        if(projectData!=null) {
            if(projectData.getOwnerId().equals(principall.getName())) {
                model.put("projectData", projectData);
                return "projectView";
            }
            else {
                model.put("error", "Nie masz prawa do oglądania tego projektu.");
                return "projectErrorPage";
            }
        }
        else {
            model.put("error", "Projekt o podanym id nie istnieje.");
            return "projectErrorPage";
        }
    }
}
