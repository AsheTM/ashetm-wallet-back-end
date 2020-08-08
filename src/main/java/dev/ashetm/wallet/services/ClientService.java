package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;

public interface ClientService {
	
	Client getClient(int idClient) throws ClientNotFoundException;
	List<Client> getAllClient();
	Client saveClient(Client client);

}
