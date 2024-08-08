package com.example.books_liberary.rest;

import com.example.books_liberary.services.PatronService;
import com.example.books_liberary.tables.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatronRestController {
    private PatronService patronService;

    @Autowired
    public PatronRestController (PatronService thePatronService){

        patronService=thePatronService;
    }
    //get list of patrons
    @GetMapping("/patrons")
    public List<Patron> findAll(){return patronService.findAll();}

    // get patron with id
    @GetMapping("/patrons/{patronId}")
    public Patron getPatron(@PathVariable int patronId){

        Patron thepatron =patronService.findById(patronId);
        if (thepatron==null)
        { throw new RuntimeException("patron Id not found--"+patronId);}
        return thepatron;
    }

    // add new Patron
    @PostMapping("/patrons")
    public Patron addPatron (@RequestBody Patron thePatron ){

        thePatron.setId(0);
        Patron dbpatron =patronService.save(thePatron);
        return dbpatron;
    }

    @PutMapping("/patrons")
    public Patron updatepatron (@RequestBody Patron thePatron){


        Patron dbPatron =patronService.save(thePatron)
                ;
        return dbPatron;
    }

    @DeleteMapping("/patrons/{patronId}")
    public String deletePatron(@PathVariable int patronid){

        Patron thepatron=patronService.findById(patronid);

        if (thepatron ==null){

            throw new RuntimeException("id not found--"+patronid);

        }
        return "deleted patron id --"+patronid;
    }

}
