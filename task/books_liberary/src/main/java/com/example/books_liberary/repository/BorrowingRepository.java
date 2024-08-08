package com.example.books_liberary.repository;

import com.example.books_liberary.tables.Borrowing_record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing_record,Integer> {
}
