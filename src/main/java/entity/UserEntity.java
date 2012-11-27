package entity;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: piotrekpaul
 * Date: 17.11.2012
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "user", schema = "", catalog = "68_cmsSpringDatabase")
@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @Size (min=3, max=25, message = "Imię może zawierać od 3 do 25 liter.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Imię może zawierać tylko litery.")
    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size (min=3, max=25, message = "Nazwisko może zawierać od 3 do 25 liter.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Nazwisko może zawierać tylko litery.")
    private String surname;

    @javax.persistence.Column(name = "surname")
    @Basic
    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Size (min=5, max=64, message = "Hasło nie może być krótsze, niż 6 znaków.")
    private String password;

    @javax.persistence.Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Timestamp registrationDate;

    @javax.persistence.Column(name = "registrationDate")
    @Basic
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Email (message = "Podano błędny adres email.")
    private String email;

    @javax.persistence.Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String role;

    @javax.persistence.Column(name = "role")
    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
