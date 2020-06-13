package com.stanley.rest.ws.restfuldemo.user;

import java.util.Date;

public class User {
    
    private Integer id;
    
    private String name;
    
    private Date brithDate;
    
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", brithDate=" + brithDate + "]";
    }
    
    

}
