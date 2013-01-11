package component.dao;

import entity.UserEntity;

import java.util.List;

public interface UserDAOInterface {

    public void add(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void delete(UserEntity userEntity);

    public Object getById(Integer uid);

    public List<UserEntity> getAll(UserEntity userEntity);
}
