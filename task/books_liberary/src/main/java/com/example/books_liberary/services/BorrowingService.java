package com.example.books_liberary.services;

import com.example.books_liberary.tables.Borrowing_record;

import java.util.List;

public interface BorrowingService {


    List<Borrowing_record> findAll();

    Borrowing_record findById(int theId);

    Borrowing_record save (Borrowing_record theborrowedbook);

    void deleteById(int theId);
}
