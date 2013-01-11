package component.dao;

import entity.FurnitureitemsEntity;
import entity.UserEntity;

import java.util.List;

public interface FurnitureDAOInterface {

    public void add(FurnitureitemsEntity furnitureEntity);

    public void update(FurnitureitemsEntity furnitureEntity);

    public void delete(FurnitureitemsEntity furnitureEntity);

    public FurnitureitemsEntity getById(String itemId);

    public List<FurnitureitemsEntity> getAll(FurnitureitemsEntity furnitureEntity);

    public List<FurnitureitemsEntity> getByCategory(String category);

    public List<FurnitureitemsEntity> getByRoom(String typeOfRoom);
}
