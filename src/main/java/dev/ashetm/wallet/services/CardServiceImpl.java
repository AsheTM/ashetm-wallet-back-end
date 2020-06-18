package dev.ashetm.wallet.services;

import java.util.List;

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
		Card account = null;
		try {
			account = cardRepository.find(idClient, idCard);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public List<Card> getAllCards(int idClient) {
		List<Card> accounts = null;
		try {
			accounts = cardRepository.findAll(idClient);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public Card saveCard(int idClient, Card card) {
		try {
			this.cardRepository.save(idClient, card);
		} catch(NotFoundException e) {
			card = null;
			e.printStackTrace();
		}
		return card;
	}

	@Override
	public boolean authenticate(int idClient, int idCard, String password) {
		Card card = this.getCard(idClient, idCard);
		
		return card.getPassword().equals(password);
	}

}
