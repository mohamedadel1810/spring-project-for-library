package com.example.books_liberary.repository;

import com.example.books_liberary.tables.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Integer> {
}
