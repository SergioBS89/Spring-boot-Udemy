package com.everis.dar.springairline.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    private String name;
    private String description;
    
    // @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "users_id")    
    private User users;
   


    public Task() {
    }
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the iduser
     */
    public User getIduser() {
        return users;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(User iduser) {
        this.users = iduser;
    }

    /**
     * @return String return the name
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
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


 
    /**
     * @return User return the users
     */
    public User getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(User users) {
        this.users = users;
    }

}