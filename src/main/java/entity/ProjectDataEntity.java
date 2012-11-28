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

    private byte[] projectData;

    @javax.persistence.Column(name = "projectData")
    @Basic
    public byte[] getProjectData() {
        return projectData;
    }

    public void setProjectData(byte[] projectData) {
        this.projectData = projectData;
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
        if (!Arrays.equals(projectData, that.projectData)) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfLastEdit != null ? dateOfLastEdit.hashCode() : 0);
        result = 31 * result + (projectData != null ? Arrays.hashCode(projectData) : 0);
        return result;
    }
}
