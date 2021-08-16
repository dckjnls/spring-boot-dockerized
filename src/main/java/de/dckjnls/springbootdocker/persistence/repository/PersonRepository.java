package de.dckjnls.springbootdocker.persistence.repository;

import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEty, Long> {
    List<PersonEty> findAllByFirstName(String firstName);
    List<PersonEty> findAllByLastName(String lastName);
}
