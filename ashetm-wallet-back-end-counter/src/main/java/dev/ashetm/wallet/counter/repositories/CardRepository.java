package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;

public interface CardRepository {
	
	Card find(int idClient, int idCard) throws NotFoundException;
	List<Card> findAll(int idClient) throws NotFoundException;
	Card save(int idClient, Card card) throws NotFoundException;

}
