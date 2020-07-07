package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.counter.utils.ClientUtil;

@Repository
public class ClientRepositoryImpl extends WalletRepositoryImpl implements ClientRepository {
	
	@Override
	public Client find(int id) throws ClientNotFoundException {
		return ClientUtil.get(WalletRepositoryImpl.clients, id);
	}

	@Override
	public List<Client> findAll() {
		return WalletRepositoryImpl.clients;
	}
	
	@Override
	public Client save(Client client) {
		WalletRepositoryImpl.clients.add(client);
		
		return client;
	}

}
