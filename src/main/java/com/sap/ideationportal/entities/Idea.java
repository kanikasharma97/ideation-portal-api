package com.sap.ideationportal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Idea {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private String content;
    private Boolean active;
    private Boolean isReadOnly;

    @OneToMany(mappedBy = "idea",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "topic_idea",
            joinColumns = @JoinColumn(name = "idea_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    @JsonIgnore
    Set<Topic> topics = new HashSet<Topic>();


    public Idea(String name, Date createdAt, Date updatedAt, String content, Boolean active, Boolean isReadOnly) {
        super();
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
        this.active = active;
        this.isReadOnly = isReadOnly;
    }

    public Idea(){
        super();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        isReadOnly = readOnly;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



}
