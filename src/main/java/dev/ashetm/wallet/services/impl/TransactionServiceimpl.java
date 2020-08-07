package dev.ashetm.wallet.services.impl;

import java.util.List;

import dev.ashetm.wallet.exceptions.TransactionNotFoundException;
import dev.ashetm.wallet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.repositories.TransactionRepository;

@Service
public class TransactionServiceimpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction getTransaction(int idClient, int idCard, int idTransaction) {
		Transaction transaction = null;
		try {
			transaction = transactionRepository.findTransaction(idClient, idCard, idTransaction)
						.orElseThrow(() -> new TransactionNotFoundException());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return transaction;
	}

	@Override
	public List<Transaction> getAllTransaction(int idClient, int idAccount) {
		List<Transaction> transactions = transactionRepository.findAllTransactions(idClient, idAccount);
		return transactions;
	}

}
