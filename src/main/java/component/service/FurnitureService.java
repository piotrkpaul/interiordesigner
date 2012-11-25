package component.service;


import component.dao.hibernate.FurnitureDAO;
import entity.FurnitureitemsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("furnitureService")
@Transactional
public class FurnitureService {

    @Autowired
    FurnitureDAO furnitureDAO;

    public List<FurnitureitemsEntity> getAllItems() {
        return furnitureDAO.getAll(new FurnitureitemsEntity());
    }

    public List<FurnitureitemsEntity> getByCategory(String category) {
        return  furnitureDAO.getByCategory(category);
    }

    public List<FurnitureitemsEntity> getByRoom(String typeOfRoom) {
        return furnitureDAO.getByRoom(typeOfRoom);
    }

    public FurnitureitemsEntity getById(String itemId) {
        return furnitureDAO.getById(itemId);
    }

    @Secured("ROLE_ADMIN")
    public void updateItem(FurnitureitemsEntity furnitureItem) {
        furnitureDAO.delete(furnitureItem);
    }

    @Secured("ROLE_ADMIN")
    public void removeItem(String itemId) {
        furnitureDAO.delete(furnitureDAO.getById(itemId));
    }

}
