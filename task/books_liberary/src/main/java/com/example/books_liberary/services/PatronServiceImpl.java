package com.example.books_liberary.services;

import com.example.books_liberary.repository.PatronRepository;
import com.example.books_liberary.tables.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatronServiceImpl implements PatronService{

private PatronRepository patronRepository;

@Autowired
public PatronServiceImpl(PatronRepository thepatronRepository){patronRepository=thepatronRepository;}
    @Override
    public List<Patron> findAll() {
        return patronRepository.findAll();
    }

    @Override
    public Patron findById(int theId) {
        Optional<Patron> result =patronRepository.findById(theId);

        Patron thepatron=null;
        if (result.isPresent()) {
            thepatron=result.get();
        }
        else {
            throw new RuntimeException("did not find patron id --" + theId);
        }
        return thepatron;
    }

    @Override
    public Patron save(Patron thepatron) {
        return patronRepository.save(thepatron);
    }

    @Override
    public void deleteById(int theId) {
patronRepository.deleteById(theId);
    }
}
