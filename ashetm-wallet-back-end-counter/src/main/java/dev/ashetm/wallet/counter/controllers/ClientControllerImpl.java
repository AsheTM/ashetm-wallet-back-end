package dev.ashetm.wallet.counter.controllers;

import java.util.List;

import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.views.responses.ClientResponseView;
import dev.ashetm.wallet.counter.views.responses.ClientsResponseView;
import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
		origins = { "http://localhost:4200", "http://localhost:4201" }, 
		maxAge = 3_600, 
		allowedHeaders = { "*" })
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
