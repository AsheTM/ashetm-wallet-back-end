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
	public Transaction getTransaction(int idClient, int idCard,
									  int idTransaction) throws TransactionNotFoundException {
		return transactionRepository.findTransaction(idClient, idCard, idTransaction)
				.orElseThrow(() -> new TransactionNotFoundException());
	}

	@Override
	public List<Transaction> getAllTransaction(int idClient, int idAccount) {
		return transactionRepository.findAllTransactions(idClient, idAccount);
	}

}
