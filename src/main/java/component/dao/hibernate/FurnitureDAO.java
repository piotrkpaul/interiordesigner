package component.dao.hibernate;

import component.dao.FurnitureDAOInterface;
import entity.FurnitureitemsEntity;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("furnitureDAO")
public class FurnitureDAO implements FurnitureDAOInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public FurnitureDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(FurnitureitemsEntity furnitureEntity) {
        sessionFactory.getCurrentSession().save(furnitureEntity);
    }

    public void update(FurnitureitemsEntity furnitureEntity) {
        sessionFactory.getCurrentSession().update(furnitureEntity);
    }

    public void delete(FurnitureitemsEntity furnitureEntity) {
        sessionFactory.getCurrentSession().delete(furnitureEntity);
    }

    public FurnitureitemsEntity getById(String itemId) {
        return (FurnitureitemsEntity) sessionFactory.getCurrentSession().createCriteria(FurnitureitemsEntity.class).add(Restrictions.eq("id", itemId)).uniqueResult();
    }

    // Getting listys by
    @Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public List<FurnitureitemsEntity> getAll(FurnitureitemsEntity furnitureEntity) {
        return sessionFactory.getCurrentSession().createCriteria(FurnitureitemsEntity.class).list();
    }

    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public List<FurnitureitemsEntity> getByCategory(String category) {
        return sessionFactory.getCurrentSession().createCriteria(FurnitureitemsEntity.class).add(Restrictions.eq("itemCategory", category)).list();
    }
    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public List<FurnitureitemsEntity> getByRoom(String typeOfRoom) {
        return sessionFactory.getCurrentSession().createCriteria(FurnitureitemsEntity.class).add(Restrictions.eq("typeOfRoom", typeOfRoom)).list();
    }
}
