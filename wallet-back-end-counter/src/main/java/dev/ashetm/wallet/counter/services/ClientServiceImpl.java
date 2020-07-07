package dev.ashetm.wallet.counter.services;

import java.util.List;

import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client getClient(int idClient) {
		Client client = null;
		try {
			client = clientRepository.find(idClient);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

}
