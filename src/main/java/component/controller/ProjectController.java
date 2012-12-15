package component.controller;

import component.service.FurnitureService;
import component.service.ProjectService;
import component.service.UserService;
import entity.ProjectDataEntity;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @Autowired
    public UserService userService;

    @Autowired
    public FurnitureService furnitureService;


    @RequestMapping(method = RequestMethod.GET, produces="text/html")
    public String showProjectList(Map<String, Object> model, Principal principal) {

        List<ProjectDataEntity> projectList = projectService.getAllProjects();
        if(projectList!=null) {
            model.put("projectList", projectList);
            if(principal!=null) {
                String userName = principal.getName();
                model.put("principal", userName);
            }
            model.put("pageHeading", "Katalog projektów");
            model.put("pageLead", "Lista projektów wszystkich użytkowników");
            return "projectList";
        }
        else {
            model.put("error", "Brak projektów w bazie.");
            return "projectErrorPage";
        }
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET, produces="text/html")
    public String showProject(@RequestParam("id") int id, Map<String, Object> model) {

        ProjectDataEntity projectData = projectService.getProject(id);
        if(projectData!=null) {
            model.put("projectData", projectData);
            return "projectDetailView";
        }
        else {
            model.put("error", "Projekt o podanym id nie istnieje.");
            return "projectErrorPage";
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces="text/html")
    public String showCurrentUserProjects(Map<String, Object> model, Principal principal) {

        model.put("projectList", projectService.getProjectsByUser(principal.getName()));
        if(principal!=null) {
            String userName = principal.getName();
            model.put("principal", userName);
        }
        model.put("pageHeading", "Twoje projekty");
        model.put("pageLead", "Projekty stworzone przez Ciebie w naszym systemie");
        return "projectList";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces="text/html")
    public String showUserProjects(@PathVariable Integer id, Map<String, Object> model, Principal principal) {

        UserEntity user = userService.getById(id);
        if(principal!=null) {
            String userName = principal.getName();
            model.put("principal", userName);
        }
        model.put("projectList", projectService.getProjectsByUser(user.getEmail()));
        return "projectList";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/create", method = RequestMethod.GET, produces="text/html")
    public String createProject(Model model) {
        model.addAttribute("pageHeading", "Kreator projektu");
        model.addAttribute("pageLead", "Stwórz projekt swojego mieszkania");
        model.addAttribute("furnitureList", furnitureService.getByCategory("beds"));
        model.addAttribute("projectDataEntity", new ProjectDataEntity());
        return "projectCreatorPage";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProjectFormHandler(@Valid ProjectDataEntity projectDataEntity, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "projectCreatorPage";
        }
        else {
            projectService.createProject(projectDataEntity, principal);
            return "redirect:/project/user" + projectDataEntity.getId();
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces="text/html")
    public String deleteProject(@PathVariable Integer id, Model model, Principal principal) {
        ProjectDataEntity project = projectService.getProject(id);
        if(project!=null) {
            if(principal.getName().equals(project.getOwnerId())){
                projectService.deleteProject(project);
                model.addAttribute("info", "Projekt zostal pomyslnie skasowany z bazy danych.");
                return "redirect:/project";
            }
            else {
                model.addAttribute("error", "Nie mozesz skasowac projektu, ktory nie nalezy do Ciebie!");
                return "redirect:/project";
            }
        }
        else {
            model.addAttribute("info", "Projekt nie istnieje.");
            return "redirect:/project";
        }
    }
}
