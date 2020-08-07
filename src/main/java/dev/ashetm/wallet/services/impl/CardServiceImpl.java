package dev.ashetm.wallet.services.impl;

import java.util.List;

import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.repositories.CardRepository;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	CardRepository cardRepository;
	
	@Override
	public Card getCard(int idClient, int idCard) {
		Card card = null;
		try {
			card = cardRepository.findCard(idClient, idCard)
					.orElseThrow(() -> new CardNotFoundException());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return card;
	}
	
	@Override
	public List<Card> getAllCards(int idClient) {
		List<Card> cards = cardRepository.findAllCards(idClient);
		return cards;
	}
	
	@Override
	public Card saveCard(int idClient, Card card) {
//		try {
//			this.cardRepository.save(idClient, card);
			this.cardRepository.save(card);
//		} catch(NotFoundException e) {
//			card = null;
//			e.printStackTrace();
//		}
		return card;
	}

	@Override
	public boolean authenticate(int idClient, int idCard, String password) {
		Card card = this.getCard(idClient, idCard);
		
		return card.getPassword()
				.equals(password);
	}

}
