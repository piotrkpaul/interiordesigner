package component.dao;

import entity.ProjectDataEntity;

import java.util.List;

public interface ProjectDAOInterface  {

    public void add(ProjectDataEntity projectEntity);

    public void update(ProjectDataEntity projectEntity);

    public void delete(ProjectDataEntity projectEntity);

    public Object getById(Integer itemId);

    public List<ProjectDataEntity> getAllByUser(String userId);

    public List<ProjectDataEntity> getAll();

}
