package com.example.books_liberary.services;

import com.example.books_liberary.tables.Books;

import java.util.List;

public interface BooksService {


    List<Books> findAll();

    Books findById(int theId);


    Books save(Books theBook);

    void deleteById(int theId);
}
