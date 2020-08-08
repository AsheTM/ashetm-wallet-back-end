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
	public Card getCard(int idClient, int idCard) throws CardNotFoundException {
		return cardRepository.findCard(idClient, idCard)
				.orElseThrow(() -> new CardNotFoundException());
	}

	@Override
	public List<Card> getAllCards(int idClient) {
		return cardRepository.findAllCards(idClient);
	}
	
	@Override
	public Card saveCard(int idClient, Card card) {
		this.cardRepository.save(card);

		return card;
	}

}
