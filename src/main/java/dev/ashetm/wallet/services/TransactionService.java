package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;

public interface TransactionService {
	
	Transaction getTransaction(int idClient, int idCard, int idTransaction) throws TransactionNotFoundException;
	List<Transaction> getAllTransaction(int idClient, int idCard);
	Transaction saveTransaction(Transaction transaction);

}
