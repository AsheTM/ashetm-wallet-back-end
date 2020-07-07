package dev.ashetm.wallet.counter.services;

import dev.ashetm.wallet.counter.models.Client;

import java.util.List;

public interface ClientService {
	
	Client getClient(int idClient);
	List<Client> getAllClient();
	Client saveClient(Client client);

}
