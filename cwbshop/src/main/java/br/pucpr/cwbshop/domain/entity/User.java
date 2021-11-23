package br.pucpr.cwbshop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


/**
 * The type User.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dtCreation", "dtUpdate"},
        allowGetters = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String login;

    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dtCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dtUpdate;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets dt creation.
     *
     * @return the dt creation
     */
    public Date getDtCreation() {
        return dtCreation;
    }

    /**
     * Sets dt creation.
     *
     * @param dtCreation the dt creation
     */
    public void setDtCreation(Date dtCreation) {
        this.dtCreation = dtCreation;
    }

    /**
     * Gets dt update.
     *
     * @return the dt update
     */
    public Date getDtUpdate() {
        return dtUpdate;
    }

    /**
     * Sets dt update.
     *
     * @param dtUpdate the dt update
     */
    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (dtCreation != null ? !dtCreation.equals(user.dtCreation) : user.dtCreation != null) return false;
        return dtUpdate != null ? dtUpdate.equals(user.dtUpdate) : user.dtUpdate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dtCreation != null ? dtCreation.hashCode() : 0);
        result = 31 * result + (dtUpdate != null ? dtUpdate.hashCode() : 0);
        return result;
    }
}