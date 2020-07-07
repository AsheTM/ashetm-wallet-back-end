package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;

public interface ClientRepository {
	
	Client find(int id) throws NotFoundException;
	List<Client> findAll();
	Client save(Client client);

}
