package component.service;

import component.dao.hibernate.ProjectDAO;
import component.dao.hibernate.UserDAO;
import entity.ProjectDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.List;

@Service("projectService")
@Transactional
public class ProjectService {

    @Autowired
    public ProjectDAO projectDAO;

    @Secured("ROLE_USER")
    public void createProject(ProjectDataEntity projectEntity, Principal principal) {

        byte[] Data = new byte[0];

        Timestamp dateOFCreation = new Timestamp(new java.util.Date().getTime());
        projectEntity.setDateOfCreation(dateOFCreation);
        projectEntity.setDateOfLastEdit(dateOFCreation);
        projectEntity.setOwnerId(principal.getName());
        projectEntity.setDataObjects(Data);
        projectEntity.setDataWalls(Data);

        projectDAO.add(projectEntity);
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



}
