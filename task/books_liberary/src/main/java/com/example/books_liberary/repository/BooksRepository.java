package com.example.books_liberary.repository;

import com.example.books_liberary.tables.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Integer> {



}
