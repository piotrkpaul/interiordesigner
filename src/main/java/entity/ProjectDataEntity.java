package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Date: 25.12.2012
 * Time: 22:37
 */
@Table(name = "projectData", schema = "", catalog = "68_cmsSpringDatabase")
@Entity
public class ProjectDataEntity {
    private int id;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String ownerId;

    @Column(name = "ownerId")
    @Basic
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    private String title;

    @Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String projectDescription;

    @Column(name = "projectDescription")
    @Basic
    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    private Timestamp dateOfCreation;

    @Column(name = "dateOfCreation")
    @Basic
    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    private Timestamp dateOfLastEdit;

    @Column(name = "dateOfLastEdit")
    @Basic
    public Timestamp getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    public void setDateOfLastEdit(Timestamp dateOfLastEdit) {
        this.dateOfLastEdit = dateOfLastEdit;
    }

    private String dataWalls;

    @Column(name = "dataWalls")
    @Basic
    public String getDataWalls() {
        return dataWalls;
    }

    public void setDataWalls(String dataWalls) {
        this.dataWalls = dataWalls;
    }


    private String dataObjects;

    @Column(name = "dataObjects")
    @Basic
    public String getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(String dataObjects) {
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
        if (dataObjects != null ? !dataObjects.equals(that.dataObjects) : that.dataObjects != null) return false;
        if (dataWalls != null ? !dataWalls.equals(that.dataWalls) : that.dataWalls != null) return false;
        if (projectDescription != null ? !projectDescription.equals(that.projectDescription) : that.projectDescription != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

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
        result = 31 * result + (dataWalls != null ? dataWalls.hashCode() : 0);
        result = 31 * result + (dataObjects != null ? dataObjects.hashCode() : 0);
        return result;
    }
}
