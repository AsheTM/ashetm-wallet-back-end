package dev.ashetm.wallet.repositories;

import java.util.List;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;

public interface TransactionRepository {
	
	Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	
	List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException;

}
