package de.dckjnls.springbootdocker.persistence;

import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import de.dckjnls.springbootdocker.persistence.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
@Slf4j
public class InitDB {

    @Bean
    public CommandLineRunner createInitialDatabaseValues(PersonRepository personRepo) {
        return args -> {
            Stream.of(new PersonEty("Dack", "Janiels"), new PersonEty("Crack", "Janiels"), new PersonEty("Jack", "Daniels"))
                    .forEach(person -> log.info("PRELOADING: {}", personRepo.save(person)));
        };
    }
}
