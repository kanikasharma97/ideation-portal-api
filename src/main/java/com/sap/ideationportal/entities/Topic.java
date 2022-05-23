package com.sap.ideationportal.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Topic {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Boolean active;


    @ManyToMany(cascade = CascadeType.MERGE,mappedBy = "topics")
    @JsonIgnore
    private Set<Idea> ideas = new HashSet<>();


    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "topics")
    private Set<User> users = new HashSet<>();


    public Topic() {
        super();
    }

    public Topic(Long id, String name, Date createdAt, Date updatedAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> user) {
        this.users = user;
    }

    public Set<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Set<Idea> ideas) {
        this.ideas = ideas;
    }
}
