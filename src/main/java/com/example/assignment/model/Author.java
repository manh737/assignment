package com.example.assignment.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;

@Entity(name= "Author")
@Table(name= "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="last_name")
    private String lastName;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
//    private Set<Book> listBook;

    @Column(name="first_name")
    private String firstName;

    @Column(name="created_at")
    @CreationTimestamp()
    private Date createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp()
    private Date updatedAt;

    public Author() {
    }

    public Author(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Author(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Set<Book> getListBook() {
//        return listBook;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
