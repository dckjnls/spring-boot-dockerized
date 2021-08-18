package de.dckjnls.springbootdocker.business.impl;

import de.dckjnls.springbootdocker.business.IPersonService;
import de.dckjnls.springbootdocker.exception.DataNotFoundException;
import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import de.dckjnls.springbootdocker.persistence.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
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

    @Nested
    @DisplayName("readPersonById(...)")
    class readPersonById {

        @Test
        @DisplayName("should ")
        void readPersonByIdShouldGetOnePerson() throws DataNotFoundException {
            // given
            Long id = 1L;
            given(personRepo.findById(id)).willReturn(Optional.of(new PersonEty()));
            // when
            personSvc.readPersonById(id);
            // then
            ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);

            verify(personRepo).findById(idCaptor.capture());
            Long capturedId = idCaptor.getValue();

            assertEquals(id, capturedId);
        }

        @Test
        @DisplayName("should throw DataNotFoundException when Person can't be found")
        void readPersonByIdShouldThrowDataNotFoundException() {
            // given
            given(personRepo.findById(any())).willReturn(Optional.empty());
            // when
            // then
            assertThrows(DataNotFoundException.class, () -> personSvc.readPersonById(1L));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException when ID is `null`")
        void readPersonByIfShouldThrowIllegalArgumentException() {
            // given
            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> personSvc.readPersonById(null));
        }
    }

    @Test
    @Disabled
    void createPerson() {
    }
}