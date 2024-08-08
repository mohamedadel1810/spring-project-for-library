package com.example.books_liberary.services;

import com.example.books_liberary.tables.Patron;

import java.util.List;

public interface PatronService {

    List<Patron> findAll();


    Patron findById(int theId);


    Patron save(Patron thepatron);

        void deleteById(int theId);

}
