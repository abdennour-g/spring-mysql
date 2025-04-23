package org.ma.mysql.service;

import org.ma.mysql.entitie.Client;
import org.ma.mysql.entitie.Open;
import org.ma.mysql.entitie.Person;
import org.ma.mysql.entitie.Status;
import org.ma.mysql.repository.ClientRepository;
import org.ma.mysql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AtFirst {
    @Bean
    CommandLineRunner go(PersonRepository personRepository, RepositoryRestConfiguration restConfiguration, ClientRepository clientRepository) {
        return a -> {
            restConfiguration.exposeIdsFor(Person.class);
            restConfiguration.exposeIdsFor(Client.class);
            personRepository.findAll().forEach(System.out::println);
            System.out.println("done !");
            File file = ResourceUtils.getFile("src/main/resources/clients1.csv");
            Scanner sc = new Scanner(file);
            SimpleDateFormat format = new SimpleDateFormat(Open.pattern);
        if(clientRepository.findAll().size()==0){
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] lineClient = line.split(",");
                Status status = Status.valueOf(lineClient[2]);
                Date date = format.parse(lineClient[3]);
                Client client = new Client(null, lineClient[0], lineClient[1], status, date);
                clientRepository.save(client);
                System.out.println(client);
            }
        }
        };
    }

}
