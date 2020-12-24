package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.counter.utils.ClientUtil;
import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.utils.CardUtil;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryImpl extends WalletRepositoryImpl implements CardRepository {

	@Override
	public Card find(int idClient, int idCard) throws NotFoundException {
		List<Card> cards = this.findAll(idClient);
		return CardUtil.get(cards, idCard);
	}

	@Override
	public List<Card> findAll(int idClient) throws ClientNotFoundException {
		Client client = ClientUtil.get(WalletRepositoryImpl.clients, idClient);
		return client.getCards();
	}
	
	@Override
	public Card save(int idClient, Card card) throws ClientNotFoundException {
		Client client = ClientUtil.get(WalletRepositoryImpl.clients, idClient);
		client.setCard(card);
		
		return card;
	}

}
