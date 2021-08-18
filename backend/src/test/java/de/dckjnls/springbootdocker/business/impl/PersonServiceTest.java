package de.dckjnls.springbootdocker.business.impl;

import de.dckjnls.springbootdocker.business.IPersonService;
import de.dckjnls.springbootdocker.persistence.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("PersonService.")
class PersonServiceTest {

    @Mock
    private PersonRepository personRepo;
    private IPersonService personSvc;

    @BeforeEach
    void setUp() {
        personSvc = new PersonService(personRepo);
    }

    @Test
    @DisplayName("readAllPeople() should execute personRepo.findAll()")
    void readAllPeople() {
        // given
        // when
        personSvc.readAllPeople();
        // then
        verify(personRepo).findAll();
    }

    @Test
    @DisplayName("readAllPeopleByFirstName(...) should execute personRepo.findAllByFirstName(...)")
    void readAllPeopleByFirstName() {
        // given
        String firstName = "TestName";
        // when
        personSvc.readAllPeopleByFirstName(firstName);
        // then
        ArgumentCaptor<String> firstNameCaptor = ArgumentCaptor.forClass(String.class);

        verify(personRepo).findAllByFirstName(firstNameCaptor.capture());
        String capturedFirstName = firstNameCaptor.getValue();

        assertEquals(firstName, capturedFirstName);
    }

    @Test
    @DisplayName("readAllPeopleByLastName(...) should execute personRepo.findAllByLastName(...)")
    void readAllPeopleByLastName() {
        // given
        String lastName = "TestName";
        // when
        personSvc.readAllPeopleByLastName(lastName);
        // then
        ArgumentCaptor<String> lastNameCaptor = ArgumentCaptor.forClass(String.class);

        verify(personRepo).findAllByLastName(lastNameCaptor.capture());
        String capturedLastName = lastNameCaptor.getValue();

        assertEquals(lastName, capturedLastName);
    }

    @Test
    @Disabled
    void createPerson() {
    }
}