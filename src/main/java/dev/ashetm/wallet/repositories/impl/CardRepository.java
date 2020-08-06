package dev.ashetm.wallet.repositories.impl;

import java.util.List;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.NotFoundException;

public interface CardRepository {
	
	Card find(int idClient, int idCard) throws NotFoundException;
	
	List<Card> findAll(int idClient) throws NotFoundException;
	
	Card save(int idClient, Card card) throws NotFoundException;

}
