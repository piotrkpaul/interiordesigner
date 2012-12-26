package entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.crypto.codec.Base64;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: piotrekpaul
 * Date: 17.11.2012
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "furnitureitems", schema = "", catalog = "68_cmsSpringDatabase")
@Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FurnitureitemsEntity {
    private String id;

    @Column(name = "id")
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String itemName;

    @Column(name = "itemName")
    @Basic
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String itemCategory;

    @Column(name = "itemCategory")
    @Basic
    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    private String typeOfRoom;

    @Column(name = "typeOfRoom")
    @Basic
    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    private String itemDescription;

    @Column(name = "itemDescription")
    @Basic
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    private String itemImageUrl;

    @Column(name = "itemImageUrl")
    @Basic
    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    private double itemPrice;

    @Column(name = "itemPrice")
    @Basic
    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    private int sizeX;

    @Column(name = "sizeX")
    @Basic
    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    private int sizeY;

    @Column(name = "sizeY")
    @Basic
    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    private int sizeZ;

    @Column(name = "sizeZ")
    @Basic
    public int getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(int sizeZ) {
        this.sizeZ = sizeZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FurnitureitemsEntity that = (FurnitureitemsEntity) o;

        if (Double.compare(that.itemPrice, itemPrice) != 0) return false;
        if (sizeX != that.sizeX) return false;
        if (sizeY != that.sizeY) return false;
        if (sizeZ != that.sizeZ) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemCategory != null ? !itemCategory.equals(that.itemCategory) : that.itemCategory != null) return false;
        if (itemDescription != null ? !itemDescription.equals(that.itemDescription) : that.itemDescription != null)
            return false;
        if (itemImageUrl != null ? !itemImageUrl.equals(that.itemImageUrl) : that.itemImageUrl != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (typeOfRoom != null ? !typeOfRoom.equals(that.typeOfRoom) : that.typeOfRoom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemCategory != null ? itemCategory.hashCode() : 0);
        result = 31 * result + (typeOfRoom != null ? typeOfRoom.hashCode() : 0);
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (itemImageUrl != null ? itemImageUrl.hashCode() : 0);
        temp = itemPrice != +0.0d ? Double.doubleToLongBits(itemPrice) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + sizeX;
        result = 31 * result + sizeY;
        result = 31 * result + sizeZ;
        return result;
    }
}
