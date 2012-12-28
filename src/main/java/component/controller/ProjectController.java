package component.controller;

import component.service.FurnitureService;
import component.service.ProjectService;
import component.service.UserService;
import entity.FurnitureItem;
import entity.ProjectDataEntity;
import entity.UserEntity;
import entity.WallItem;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.*;

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
            projectDataEntity.setOwnerId(principal.getName());
            projectService.createProject(projectDataEntity);
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


    /*
     Api mapping
     */
    @RequestMapping(value ="/", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Object getProjectList(@RequestParam("username") String email, @RequestParam("password") String password) throws IOException {
        UserEntity userEntity = userService.getCredentials(email, password);
        if(userEntity.getId()!=0) {

            return projectService.apiGetProjectListByUser(userEntity.getEmail());
        } else {
            return "WrongCredentionals";
        }

    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Object getProjectData(@PathVariable Integer id, @RequestParam("username") String email, @RequestParam("password") String password) throws IOException {
        UserEntity userEntity = userService.getCredentials(email, password);
        if(userEntity.getId()!=0) {
            ProjectDataEntity projectDataEntity = projectService.getProject(id);
            if(projectDataEntity!=null) {
                if (projectDataEntity.getOwnerId().equals(userEntity.getEmail())) {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.writeValueAsString(projectDataEntity);
                } else {
                    return "NowAnOwner";
                }
            } else {
                return "ProjectDoesntExist";
            }
        } else {
            return "WrongCredentionals";
        }
    }

    @RequestMapping(value ="/", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public Object apiCreateProject(@RequestParam("title") String title,
                                @RequestParam("desc") String description,
                                @RequestParam("walls") Object walls,
                                @RequestParam("furniture") Object furniture,
                                @RequestParam("username") String email,
                                @RequestParam("password") String password) {

        UserEntity userEntity = userService.getCredentials(email, password);
        if(userEntity!=null) {

            List<String> status = null;
            if(title.isEmpty()){
                status.add("TitleEmpty");
            }
            if(description.isEmpty()) {
                status.add("DescEmpty");
            }
            if(walls.equals(null)) {
                status.add("WallsIsNull");
            }
            if(furniture.equals(null)) {
                status.add("FurnitureIsNull");
            }

            if(status != null) {
                return status.toArray();
            } else {
                ProjectDataEntity projectData = new ProjectDataEntity();

                projectData.setOwnerId(userEntity.getEmail());
                projectData.setTitle(title);
                projectData.setProjectDescription(description);

               /*

                ArrayList<FurnitureItem> furnitureList = new ArrayList<FurnitureItem>();

                ArrayList<WallItem> wallList = new ArrayList<WallItem>();

                    furnitureList.add(new FurnitureItem("ID123", 5, 10, 20, 35));
                    furnitureList.add(new FurnitureItem("ID1fg23", 15, 30, 50, 55));
                    furnitureList.add(new FurnitureItem("ID1df23", 35, 13, 40, 36));

                    WallItem w1 = new WallItem(3, 4, 5, 6);
                    WallItem w2 = new WallItem(8, 7, 5, 4);
                    WallItem w3 = new WallItem(5, 4, 2, 1);

                    wallList.add(w1);
                    wallList.add(w2);
                    wallList.add(w3);

                ObjectMapper mapper = new ObjectMapper();

                try {
                    String furnitureJson = mapper.writeValueAsString(furnitureList);
                    projectData.setDataObjects(furnitureJson);

                    String wallJson = mapper.writeValueAsString(wallList);
                    projectData.setDataWalls(wallJson);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                */

                projectData.setDataObjects((String)furniture);
                projectData.setDataWalls((String)walls);

                projectService.createProject(projectData);
                return "ProjectCreated";
            }

        } else {
            return "WrongCredentionals";
        }
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, produces="application/json")
    @ResponseBody
    public Object apiUpdateProject(@PathVariable("id") Integer id,
                                   @RequestParam(value = "title", required=false) String title,
                                   @RequestParam(value = "desc", required=false) String description,
                                   @RequestParam("walls") String walls,
                                   @RequestParam("furniture") String furniture,
                                   @RequestParam("username") String email,
                                   @RequestParam("password") String password) {

        UserEntity userEntity = userService.getCredentials(email, password);
        if(userEntity!=null) {
            ProjectDataEntity projectData = projectService.getProject(id);
            if(projectData!=null) {
                if (projectData.getOwnerId().equals(email)) {


                    if(!walls.isEmpty()) {
                        projectData.setDataWalls((String)walls);
                    }
                    if(!furniture.isEmpty()) {
                        projectData.setDataObjects((String)furniture);
                    }
                    if(title!=null){
                        projectData.setTitle(title);
                    }
                    if(description!=null) {
                        projectData.setProjectDescription(description);
                    }

                    projectService.apiUpdateProject(projectData);
                    return "ProjectUpdated";
                } else {
                    return "NowAnOwner";
                }
            } else {
                return "ProjectDoesntExist";
            }
        } else {
            return "WrongCredentionals";
        }
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE, produces="application/json")
    @ResponseBody
    public Object deleteProjectData(@PathVariable Integer id) {
        ProjectDataEntity projectDataEntity = projectService.getProject(id);
        if(projectDataEntity!=null) {
            projectService.deleteProject(projectDataEntity);
            return "Deleted";
        } else {
            return "ProjectDoesntExist";
        }
    }
}