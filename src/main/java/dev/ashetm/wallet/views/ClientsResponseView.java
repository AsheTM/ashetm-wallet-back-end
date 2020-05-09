package dev.ashetm.wallet.views;

import java.time.LocalDate;
import java.util.List;

import dev.ashetm.wallet.entities.Client;

public class ClientsResponseView implements ResponseView {
	
	private List<Client> clients;
	
	private LocalDate now = LocalDate.now();

	public ClientsResponseView() {
	}

	public ClientsResponseView(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public static List<Client> to(ClientsResponseView clientsResponseView) {
		return clientsResponseView.getClients();
	}
	
	public static ClientsResponseView from(List<Client> clients) {
		return new ClientsResponseView(clients);
	}

}
