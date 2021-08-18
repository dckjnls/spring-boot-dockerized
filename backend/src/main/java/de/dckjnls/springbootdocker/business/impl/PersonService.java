package de.dckjnls.springbootdocker.business.impl;

import de.dckjnls.springbootdocker.business.IPersonService;
import de.dckjnls.springbootdocker.exception.DataNotFoundException;
import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import de.dckjnls.springbootdocker.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepo;

    @Autowired
    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    @Autowired


    @Override
    public List<PersonEty> readAllPeople() {
        return personRepo.findAll();
    }

    @Override
    public List<PersonEty> readAllPeopleByFirstName(String firstName) {
        return personRepo.findAllByFirstName(firstName);
    }

    @Override
    public List<PersonEty> readAllPeopleByLastName(String lastName) {
        return personRepo.findAllByLastName(lastName);
    }

    @Override
    public PersonEty readPersonById(Long id) throws DataNotFoundException {
        if(id == null) throw new IllegalArgumentException("Parameter 'id' can't be `null`");

        Optional<PersonEty> person = personRepo.findById(id);
        if(person.isEmpty()) throw new DataNotFoundException();

        return person.get();
    }

    @Override
    public PersonEty createPerson(PersonEty person) {
        return personRepo.save(person);
    }
}
