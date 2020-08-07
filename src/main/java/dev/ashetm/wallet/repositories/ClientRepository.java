package dev.ashetm.wallet.repositories;

import dev.ashetm.wallet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> { }
