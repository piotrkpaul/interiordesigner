package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: piotrekpaul
 * Date: 17.11.2012
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "articleContents", schema = "", catalog = "68_cmsSpringDatabase")
@Entity
public class ArticleContentsEntity {
    private String hashName;

    @Column(name = "hashName")
    @Id
    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
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

    private String content;

    @Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleContentsEntity that = (ArticleContentsEntity) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(that.dateOfCreation) : that.dateOfCreation != null)
            return false;
        if (dateOfLastEdit != null ? !dateOfLastEdit.equals(that.dateOfLastEdit) : that.dateOfLastEdit != null)
            return false;
        if (hashName != null ? !hashName.equals(that.hashName) : that.hashName != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hashName != null ? hashName.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfLastEdit != null ? dateOfLastEdit.hashCode() : 0);
        return result;
    }
}
