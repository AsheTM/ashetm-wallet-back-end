package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Card;

public interface CardService {
	
	Card getCard(int idClient, int idCard);
	
	List<Card> getAllCards(int idClient);
	
	Card saveCard(int idClient, Card card);
	
	boolean authenticate(int idClient, int idCard, String password);

}
