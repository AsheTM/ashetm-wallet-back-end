package dev.ashetm.wallet.repositories.impl;

import java.util.List;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.NotFoundException;

public interface ClientRepository {
	
	Client find(int id) throws NotFoundException;
	
	List<Client> findAll();
	
	Client save(Client client);

}
