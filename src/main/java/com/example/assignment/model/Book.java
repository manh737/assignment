package com.example.assignment.model;

import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected int id;

    @Column(name="name")
    protected String name;

    @Column(name="author_id")
    protected String authorId;

    public Book() {
    }

    public Book(String name, String authorId) {
        super();
        this.name = name;
        this.authorId = authorId;
    }

    public Book(int id, String name, String authorId) {
        super();
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
