package dev.ashetm.wallet.counter.services;

import dev.ashetm.wallet.counter.models.Card;

import java.util.List;

public interface CardService {
	
	Card getCard(int idClient, int idCard);
	List<Card> getAllCards(int idClient);
	Card saveCard(int idClient, Card card);
	boolean authenticate(int idClient, int idCard, String password);

}
