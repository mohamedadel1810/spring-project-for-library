package com.example.books_liberary.rest;

import com.example.books_liberary.services.BookServiceImpl;
import com.example.books_liberary.services.BorrowingService;
import com.example.books_liberary.tables.Borrowing_record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowingRestController {


    private BorrowingService borrowingService;


    @Autowired
    public BorrowingRestController (BorrowingService theBorrowingService){
        borrowingService=theBorrowingService;
    }
    @PostMapping("/borrow")
    public Borrowing_record borrowbook(@RequestBody Borrowing_record theBorrowingRecord){

        theBorrowingRecord.setId(0);

        Borrowing_record dbborrow = borrowingService.save(theBorrowingRecord);

        return dbborrow;

    }
    @PutMapping("/return")
    public Borrowing_record Return(@RequestBody Borrowing_record theBorrowingRecord){

        Borrowing_record dbborrow =borrowingService.save(theBorrowingRecord);
        return dbborrow;

    }
}
