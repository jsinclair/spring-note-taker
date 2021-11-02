package com.example.notetaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String fullName;

    protected Person() {
    }

    /*
     * This is a default constructor for person models!
     */
    public Person(String title, String fullName) {
        this.title = title;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return String.format("Note\nid=%d, title=%s\n%s", id, title, fullName);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
