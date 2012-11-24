package component.dao.hibernate;


import component.dao.UserDAOInterface;
import entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAO")
public class UserDAO implements UserDAOInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.sessionFactory.openSession();
    }

    public void add(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
    }

    public void update(UserEntity userEntity) {
        sessionFactory.getCurrentSession().update(userEntity);
    }

    public void delete(UserEntity userEntity) {
        sessionFactory.getCurrentSession().delete(userEntity);
    }


    public UserEntity getById(Integer uid) {
        return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, uid);
    }

    public List<UserEntity> getAll(UserEntity userEntity) {
        return sessionFactory.getCurrentSession().createCriteria(UserEntity.class).list();
    }
}
