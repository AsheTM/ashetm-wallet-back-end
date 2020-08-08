package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.CardNotFoundException;

public interface CardService {
	
	Card getCard(int idClient, int idCard) throws CardNotFoundException;
	List<Card> getAllCards(int idClient);
	Card saveCard(Card card);

}
