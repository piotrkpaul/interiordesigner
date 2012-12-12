package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: piotrekpaul
 * Date: 17.11.2012
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "projectData", schema = "", catalog = "68_cmsSpringDatabase")
@Entity
public class ProjectDataEntity {

    @GeneratedValue
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String ownerId;

    @javax.persistence.Column(name = "ownerId")
    @Basic
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    private String title;

    @javax.persistence.Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String projectDescription;

    @javax.persistence.Column(name = "projectDescription")
    @Basic
    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    private Timestamp dateOfCreation;

    @javax.persistence.Column(name = "dateOfCreation")
    @Basic
    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    private Timestamp dateOfLastEdit;

    @javax.persistence.Column(name = "dateOfLastEdit")
    @Basic
    public Timestamp getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    public void setDateOfLastEdit(Timestamp dateOfLastEdit) {
        this.dateOfLastEdit = dateOfLastEdit;
    }

    private byte[] dataWalls;

    @javax.persistence.Column(name = "dataWalls")
    @Basic
    public byte[] getDataWalls() {
        return dataWalls;
    }

    public void setDataWalls(byte[] dataWalls) {
        this.dataWalls = dataWalls;
    }

    private byte[] dataObjects;

    @javax.persistence.Column(name = "dataObjects")
    @Basic
    public byte[] getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(byte[] dataObjects) {
        this.dataObjects = dataObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectDataEntity that = (ProjectDataEntity) o;

        if (id != that.id) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(that.dateOfCreation) : that.dateOfCreation != null)
            return false;
        if (dateOfLastEdit != null ? !dateOfLastEdit.equals(that.dateOfLastEdit) : that.dateOfLastEdit != null)
            return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (!Arrays.equals(dataWalls, that.dataWalls)) return false;
        if (!Arrays.equals(dataObjects, that.dataObjects)) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (projectDescription != null ? !projectDescription.equals(that.projectDescription) : that.projectDescription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfLastEdit != null ? dateOfLastEdit.hashCode() : 0);
        result = 31 * result + (dataWalls != null ? Arrays.hashCode(dataWalls) : 0);
        result = 31 * result + (dataObjects != null ? Arrays.hashCode(dataObjects) : 0);
        return result;
    }
}
