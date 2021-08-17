package de.dckjnls.springbootdocker.business;

import de.dckjnls.springbootdocker.persistence.entity.PersonEty;

import java.util.List;

public interface IPersonService {

    List<PersonEty> readAllPeople();

    List<PersonEty> readAllPeopleByFirstName(String firstName);

    List<PersonEty> readAllPeopleByLastName(String lastName);

    PersonEty createPerson(PersonEty person);
}
