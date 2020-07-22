package com.ryjios.ms.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about user.")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

   // @Size(min = 3, message = "First Name should have at least 3 characters")
    //@ApiModelProperty(notes = "First Name should have at least 3 characters")
    private String firstName;

    //@Size(min = 3, message = "Last Name should have at least 3 characters")
    //@ApiModelProperty(notes = "Last Name should have at least 3 characters")
    private String lastName;

    @Past
    @ApiModelProperty(notes = "Birth date should in in the past")
    private Date brithDate;

    @Email (message="Email Id should in proper format")
    @NotNull
    private String userEmailId;
    
    @Size(min = 4, message = "Password should be at least 4 characters")
    @NotNull
    private String userPassword;

    
    public User() {

    }

    public User(Integer id, String firstName, String lastName, Date brithDate, String emailId, String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.brithDate = brithDate;
        this.userPassword = password;
        this.userEmailId = emailId;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the brithDate
     */
    public Date getBrithDate() {
        return brithDate;
    }

    /**
     * @param brithDate the brithDate to set
     */
    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    /**
     * @return the userEmailId
     */
    public String getUserEmailId() {
        return userEmailId;
    }

    /**
     * @param userEmailId the userEmailId to set
     */
    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", brithDate=" + brithDate
                + ", userEmailId=" + userEmailId + ", userPassword=" + userPassword + "]";
    }

    

    

}
