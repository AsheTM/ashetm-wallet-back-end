package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;

public interface TransactionRepository {
	
	Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException;

}
