package component.dao.hibernate;

import component.dao.ProjectDAOInterface;
import entity.ProjectDataEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        System.out.println(projectEntity.getId());
        sessionFactory.getCurrentSession().flush();
        System.out.println(projectEntity.getId());
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

    public ArrayList<ProjectDataEntity> getAllByUser(String userId) {
        return (ArrayList<ProjectDataEntity>) sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).setProjection(Projections.projectionList()
                .add(Projections.property("id"))
                .add(Projections.property("dateOfCreation"))
                .add(Projections.property("dateOfLastEdit"))
                .add(Projections.property("ownerId"))
                .add(Projections.property("title"))
                .add(Projections.property("projectDescription")))
            .add(Restrictions.eq("ownerId", userId)).list();
    }

    public List<ProjectDataEntity> getListByUser(String userId) {
        return sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).add(Restrictions.eq("ownerId", userId)).list();

    }

    public List<ProjectDataEntity> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(ProjectDataEntity.class).list();
    }
}
