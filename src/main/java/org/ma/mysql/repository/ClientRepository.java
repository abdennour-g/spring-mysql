package org.ma.mysql.repository;

import org.ma.mysql.entitie.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}

