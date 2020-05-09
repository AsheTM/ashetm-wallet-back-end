package dev.ashetm.wallet.views;

import java.time.LocalDate;

import dev.ashetm.wallet.entities.Client;

public class ClientResponseView implements ResponseView {
	
	private Client client;
	
	private LocalDate now = LocalDate.now();

	public ClientResponseView() {
	}

	public ClientResponseView(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public static Client to(ClientResponseView clientResponseView) {
		return clientResponseView.getClient();
	}
	
	public static ClientResponseView from(Client client) {
		return new ClientResponseView(client);
	}

}
