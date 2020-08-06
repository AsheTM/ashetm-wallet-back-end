package dev.ashetm.wallet.repositories;

import java.util.List;

import dev.ashetm.wallet.repositories.impl.CardRepository;
import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.utils.CardUtil;
import dev.ashetm.wallet.utils.ClientUtil;

@Repository
public class CardRepositoryImpl extends WalletRepositoryImpl implements CardRepository {

	@Override
	public Card find(int idClient, int idCard) throws NotFoundException {
		List<Card> cards = this.findAll(idClient);
		return CardUtil.get(cards, idCard);
	}

	@Override
	public List<Card> findAll(int idClient) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		return client.getCards();
	}
	
	@Override
	public Card save(int idClient, Card card) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		client.setCard(card);
		
		return card;
	}

}
