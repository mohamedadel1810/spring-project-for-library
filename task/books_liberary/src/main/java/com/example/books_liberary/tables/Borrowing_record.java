package com.example.books_liberary.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowing_record")
public class Borrowing_record {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;

@Column(name = "book_id")
    private int book_id;

    @Column(name = "patron_id")
    private int patron_id;


    @Column(name = "borrow_date")
    private String borrow_date;


    @Column(name = "return_date")
    private String return_date;

    // define constructors

    public Borrowing_record(){}

    public Borrowing_record(int id, int book_id, int patron_id, String borrow_date, String return_date) {
        this.id = id;
        this.book_id = book_id;
        this.patron_id = patron_id;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    //  define getters/setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(int patron_id) {
        this.patron_id = patron_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
