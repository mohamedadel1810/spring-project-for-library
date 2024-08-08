package com.example.books_liberary.services;

import com.example.books_liberary.repository.BorrowingRepository;
import com.example.books_liberary.tables.Borrowing_record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService{


    private BorrowingRepository borrowingRepository;
    @Autowired
    public BorrowingServiceImpl ( BorrowingRepository theBorrowingRepository
    ){

        borrowingRepository=theBorrowingRepository;

    }


    @Override
    public List<Borrowing_record> findAll() {
        return borrowingRepository.findAll();
    }

    @Override
    public Borrowing_record findById(int theId) {
        Optional<Borrowing_record> results = borrowingRepository.findById(theId);

 Borrowing_record theborrwingrecord=null;

 if (results.isPresent()){ theborrwingrecord =results.get();}
 else {throw new RuntimeException("id not found "+ theId);}

 return theborrwingrecord;
    }

    @Override
    public Borrowing_record save(Borrowing_record theborrowedbook) {
        return borrowingRepository.save(theborrowedbook);
    }

    @Override
    public void deleteById(int theId) {
        borrowingRepository.deleteById(theId);

    }
}
