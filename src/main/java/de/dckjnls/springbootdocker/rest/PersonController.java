package de.dckjnls.springbootdocker.rest;

import de.dckjnls.springbootdocker.business.IPersonService;
import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private final IPersonService personSvc;

    @Autowired
    public PersonController(IPersonService personSvc) {
        this.personSvc = personSvc;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonEty>> getAllPeople() {
        return new ResponseEntity<>(personSvc.readAllPeople(), HttpStatus.OK);
    }
}
