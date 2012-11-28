package component.dao.hibernate;

import component.dao.ProjectDAOInterface;
import entity.ProjectDataEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date: 28.11.2012
 * Time: 00:03
 */
@Repository("projetDAO")
public class ProjectDAO implements ProjectDAOInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public ProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(ProjectDataEntity projectEntity) {
        sessionFactory.getCurrentSession().save(projectEntity);
    }

    public void update(ProjectDataEntity projectEntity) {
        sessionFactory.getCurrentSession().update(projectEntity);
    }

    public void delete(ProjectDataEntity projectEntity) {
        sessionFactory.getCurrentSession().delete(projectEntity);
    }

    public ProjectDataEntity getById(Integer itemId) {
        return (ProjectDataEntity) sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).add(Restrictions.eq("id", itemId)).uniqueResult();
    }

    public List<ProjectDataEntity> getAllByUser(String userId) {
        return sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).add(Restrictions.eq("ownerId", userId)).list();

    }

    public List<ProjectDataEntity> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).list();
    }
}
