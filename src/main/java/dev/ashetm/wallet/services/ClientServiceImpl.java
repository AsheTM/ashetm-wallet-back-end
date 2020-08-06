package dev.ashetm.wallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.repositories.impl.ClientRepository;

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
