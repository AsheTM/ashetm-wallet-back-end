package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.views.request.ClientRequestView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.services.ClientService;
import dev.ashetm.wallet.views.response.ClientResponseView;
import dev.ashetm.wallet.views.response.ClientsResponseView;

@RestController
@CrossOrigin(
		origins = { "http://localhost:4200", "http://localhost:4201" }, 
		maxAge = 3_600, 
		allowedHeaders = { "*" })
public class ClientControllerImpl implements WalletController.ClientController {

	private final ClientService clientService;

	private final Logger LOGGER = LoggerFactory.getLogger(ClientControllerImpl.class);
	
	@Autowired
	public ClientControllerImpl(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ResponseEntity<ClientsResponseView> showClients() {
		List<Client> clients = this.clientService.getAllClient();
		
		return ResponseEntity.ok(ClientsResponseView.from(clients));
	}

	@Override
	public ResponseEntity<ClientResponseView> showClient(int idClient) {
		Client client = null;
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			client = this.clientService.getClient(idClient);
		} catch (ClientNotFoundException clientNotFoundException) {
			LOGGER.error(clientNotFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		}
		
		return ResponseEntity
				.status(httpStatus)
				.body(ClientResponseView.from(client));
	}

	@Override
	public ResponseEntity<ClientResponseView> addClient(ClientRequestView clientRequestView) {
		Client client = ClientRequestView.to(clientRequestView);
		Client clientSaved = this.clientService.saveClient(client);

		return ResponseEntity.ok(ClientResponseView.from(clientSaved));
	}
	
}
