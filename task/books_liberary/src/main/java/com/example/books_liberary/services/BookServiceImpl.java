package com.example.books_liberary.services;

import com.example.books_liberary.repository.BooksRepository;
import com.example.books_liberary.tables.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BooksService {

    private BooksRepository booksRepository;

    @Autowired
    public BookServiceImpl (BooksRepository  theBooksRepository ){  booksRepository= theBooksRepository ;}


    @Override
    public List<Books> findAll(){

        return booksRepository.findAll();

    }
    @Override
    public Books findById(int theId){

        Optional<Books> result =booksRepository.findById(theId);


        Books thebook = null ;

        if (result.isPresent()){

            thebook=result.get();
        }
        else {
            throw new RuntimeException("did not find employee id -- "+theId);
        }
        return thebook;
    }

    @Override
    public Books save(Books theBook) {
        return booksRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
booksRepository.deleteById(theId);
    }


}
