package dev.ashetm.wallet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.services.ClientService;
import dev.ashetm.wallet.views.ClientResponseView;
import dev.ashetm.wallet.views.ClientsResponseView;

@RestController
public class ClientControllerImpl implements WalletController.ClientController {

	private ClientService clientService;
	
	@Autowired
	public ClientControllerImpl(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ClientsResponseView showClients() throws NotFoundException {
		List<Client> clients = this.clientService.getAllClient();
		
		return ClientsResponseView.from(clients);
	}

	@Override
	public ClientResponseView showClient(int idClient) throws NotFoundException {
		Client client = this.clientService.getClient(idClient);
		
		return ClientResponseView.from(client);
	}

	@Override
	public ClientResponseView addClient(Client client) throws NotFoundException {
		client = this.clientService.saveClient(client);
		
		return ClientResponseView.from(client);
	}
	
}