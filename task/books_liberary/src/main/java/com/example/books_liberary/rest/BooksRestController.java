package com.example.books_liberary.rest;

import com.example.books_liberary.services.BooksService;
import com.example.books_liberary.tables.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksRestController {

    private BooksService booksService;
    @Autowired
    public BooksRestController (BooksService theBooksService){booksService=theBooksService;}


    //return list of books
    @GetMapping("/books")
    public List<Books> findAll(){return booksService.findAll();}

// get book with id
    @GetMapping("/books/{bookId}")
    public Books getbook(@PathVariable int bookId){ Books thebook =booksService.findById(bookId);

    if (thebook ==null){
        throw new RuntimeException("book ID not found--"+bookId);

    }
    return thebook;
    }


    // add new book

    @PostMapping("/books")
    public Books addBook(@RequestBody Books theBook){

        theBook.setId(0);

        Books dbBook = booksService.save(theBook);
        return dbBook;
    }

// update book

    @PutMapping ("/books")
    public Books updateBook(@RequestBody Books thebook)
    { Books dbbook =booksService.save(thebook);
    return dbbook;
    }

    // delete book

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookID){
        Books tempbook =booksService.findById(bookID);

        if (tempbook==null){
            throw new RuntimeException("book id not found "+bookID);

        }
        booksService.deleteById(bookID);

        return "deleted book id --"+bookID;
    }

}
