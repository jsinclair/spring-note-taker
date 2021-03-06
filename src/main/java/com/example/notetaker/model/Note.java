package com.example.notetaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    protected Note() {
    }

    /*
     * This is a default constructor for note models!
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Note\nid=%d, title=%s\n%s", id, title, content);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
