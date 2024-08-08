package com.example.books_liberary.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Books {

    //define fields

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;


    @Column(name = "title")
    private String  title;


    @Column(name = "author_name")
    private String  author_name;

    @Column(name = "publication_year")
    private String  publication_year;


    /*

    define constructors

     */


public Books(){}

    public Books(int id, String title, String author_name, String publication_year) {
        this.id = id;
        this.title = title;
        this.author_name = author_name;
        this.publication_year = publication_year;
    }

// define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }
}
