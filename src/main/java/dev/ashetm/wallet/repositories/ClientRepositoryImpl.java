package dev.ashetm.wallet.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.utils.ClientUtil;

@Repository
public class ClientRepositoryImpl extends WalletRepositoryImpl implements ClientRepository {
	
	@Override
	public Client find(int id) throws ClientNotFoundException {
		return ClientUtil.get(clients, id);
	}

	@Override
	public List<Client> findAll() {
		return clients;
	}
	
	@Override
	public Client save(Client client) {
		clients.add(client);
		
		return client;
	}

}
