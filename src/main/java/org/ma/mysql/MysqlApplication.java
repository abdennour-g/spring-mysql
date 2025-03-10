package org.ma.mysql;

import org.ma.mysql.entitie.Person;
import org.ma.mysql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
@SpringBootApplication
public class MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

    @Bean
    CommandLineRunner go(PersonRepository personRepository,RepositoryRestConfiguration restConfiguration) {
        return a -> {
            restConfiguration.exposeIdsFor(Person.class);
            personRepository.findAll().forEach(System.out::println);
            System.out.println("done !");
        };
    }
}
