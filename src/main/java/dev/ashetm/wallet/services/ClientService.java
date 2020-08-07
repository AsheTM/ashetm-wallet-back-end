package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Client;

public interface ClientService {
	
	Client getClient(int idClient);
	List<Client> getAllClient();
	Client saveClient(Client client);

}
