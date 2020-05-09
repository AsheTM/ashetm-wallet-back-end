package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;

public interface TransactionService {
	
	Transaction getTransaction(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	
	List<Transaction> getAllTransaction(int idClient, int idAccount) throws NotFoundException;

}
