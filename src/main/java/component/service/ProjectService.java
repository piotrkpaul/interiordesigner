package component.service;

import component.dao.hibernate.ProjectDAO;
import entity.ProjectDataEntity;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("projectService")
@Transactional
public class ProjectService {

    @Autowired
    public ProjectDAO projectDAO;

    @Secured("ROLE_USER")
    public Integer createProject(ProjectDataEntity projectEntity) {

        Timestamp dateOFCreation = new Timestamp(new java.util.Date().getTime());
        projectEntity.setDateOfCreation(dateOFCreation);
        projectEntity.setDateOfLastEdit(dateOFCreation);

        projectDAO.add(projectEntity);
        return projectEntity.getId();
    }

    @Secured("ROLE_USER")
    public void updateProject(ProjectDataEntity projectEntity) {
        projectDAO.update(projectEntity);
    }

    @Secured("ROLE_USER")
    public void deleteProject(ProjectDataEntity projectEntity) {
        projectDAO.delete(projectEntity);
    }

    public ProjectDataEntity getProject(Integer projectId) {
        return projectDAO.getById(projectId);
    }

    public List<ProjectDataEntity> getProjectsByUser(String userId) {

        return projectDAO.getAllByUser(userId);
    }

    public List<ProjectDataEntity> getAllProjects() {
        return projectDAO.getAll();
    }

    /* Api Methods */
    public String apiGetProjectListByUser(String userId) throws IOException {
        List<ProjectDataEntity> database = projectDAO.getListByUser(userId);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(database);
    }


    public void apiUpdateProject(ProjectDataEntity projectData) {
        Timestamp dateOFEdit = new Timestamp(new java.util.Date().getTime());

        projectData.setDateOfLastEdit(dateOFEdit);
        projectDAO.update(projectData);
    }
}
