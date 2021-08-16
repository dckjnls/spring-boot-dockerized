package de.dckjnls.springbootdocker.persistence;

import de.dckjnls.springbootdocker.persistence.entity.PersonEty;
import de.dckjnls.springbootdocker.persistence.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitDB {

    @Bean
    public CommandLineRunner createInitialDatabaseValues(PersonRepository personRepo) {
        return args -> {
            PersonEty person1 = new PersonEty("Dack", "Janiels");
            log.info("PRELOADING: {}", personRepo.save(person1));
        };
    }
}
