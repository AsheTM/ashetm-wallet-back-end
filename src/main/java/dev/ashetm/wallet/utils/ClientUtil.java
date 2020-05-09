package dev.ashetm.wallet.utils;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;

public class ClientUtil implements IEntityUtil<Client> {

	public static Optional<Client> find(List<Client> clients, int idC) {
		return IEntityUtil.getStream(clients).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Client get(List<Client> clients, int idC) throws ClientNotFoundException {
		return ClientUtil.find(clients, idC).orElseThrow(() -> new ClientNotFoundException());
	}
	
}
