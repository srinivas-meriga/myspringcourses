package com.stanley.rest.ws.restfuldemo.user;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="All details about user.")
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min=2, message="Name should have at least 2 characters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;
    
    @Past   
    @ApiModelProperty(notes="Birth date should in in the past")
    private Date brithDate;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    
    protected User() {
        
    }

    /**
     * @param id
     * @param name
     * @param brithDate
     */
    public User(Integer id, String name, Date brithDate) {
        super();
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", brithDate=" + brithDate + "]";
    }
    
    

}
