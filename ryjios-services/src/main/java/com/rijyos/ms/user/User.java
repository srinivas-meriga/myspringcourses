package com.rijyos.ms.user;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about user.")
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String userId;

    // @Size(min = 3, message = "First Name should have at least 3 characters")
    // @ApiModelProperty(notes = "First Name should have at least 3 characters")
    private String firstName;

    // @Size(min = 3, message = "Last Name should have at least 3 characters")
    // @ApiModelProperty(notes = "Last Name should have at least 3 characters")
    private String lastName;

    @Past
    @ApiModelProperty(notes = "Birth date should in in the past")
    private Date brithDate;

    @Email(message = "Email Id should in proper format")
    @NotNull
    private String userEmailId;

    @Size(min = 4, message = "Password should be at least 4 characters")
    @NotNull
    private String userPassword;

    private Timestamp regestiredDate;

    private Timestamp updatedDate;

    public User() {

    }

    public User(String userId, String firstName, String lastName, @Past Date brithDate,
            @Email(message = "Email Id should in proper format") String userEmailId,
            @Size(min = 4, message = "Password should be at least 4 characters") String userPassword,
            Timestamp regestiredDate, Timestamp updatedDate) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.brithDate = brithDate;
        this.userEmailId = userEmailId;
        this.userPassword = userPassword;
        this.regestiredDate = regestiredDate;
        this.updatedDate = updatedDate;
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

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    

    /**
     * @return the regestiredDate
     */
    public Timestamp getRegestiredDate() {
        return regestiredDate;
    }

    /**
     * @param regestiredDate the regestiredDate to set
     */
    public void setRegestiredDate(Timestamp regestiredDate) {
        this.regestiredDate = regestiredDate;
    }

    /**
     * @return the updatedDate
     */
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", brithDate="
                + brithDate + ", userEmailId=" + userEmailId + ", userPassword=" + userPassword + ", regestiredDate="
                + regestiredDate + ", updatedDate=" + updatedDate + "]";
    }

   

}
