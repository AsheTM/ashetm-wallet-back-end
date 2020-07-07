package dev.ashetm.wallet.counter.utils;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.ClientNotFoundException;

public class ClientUtil implements IEntityUtil<Client> {

	public static Optional<Client> find(List<Client> clients, int idC) {
		return IEntityUtil.getStream(clients).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Client get(List<Client> clients, int idC) throws ClientNotFoundException {
		return ClientUtil.find(clients, idC).orElseThrow(() -> new ClientNotFoundException());
	}
	
}
