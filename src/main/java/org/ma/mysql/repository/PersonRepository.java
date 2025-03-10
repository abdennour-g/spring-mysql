package org.ma.mysql.repository;

import org.ma.mysql.entitie.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestResource
//@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
}
