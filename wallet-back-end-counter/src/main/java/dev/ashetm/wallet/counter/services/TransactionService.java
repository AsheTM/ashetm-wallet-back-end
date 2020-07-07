package dev.ashetm.wallet.counter.services;

import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;

import java.util.List;

public interface TransactionService {
	
	Transaction getTransaction(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	List<Transaction> getAllTransaction(int idClient, int idAccount) throws NotFoundException;

}
