package dev.ashetm.wallet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.services.TransactionService;
import dev.ashetm.wallet.views.TransactionResponseView;
import dev.ashetm.wallet.views.TransactionsResponseView;

@RestController
public class TransactionControllerImpl implements WalletController.TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@Override
	public TransactionsResponseView showTransactions(int idClient, int idAccount) throws NotFoundException {
		List<Transaction> transactions = this.transactionService.getAllTransaction(idClient, idAccount);
		
		return TransactionsResponseView.from(transactions);
	}
	
	@Override
	public TransactionResponseView showTransaction(int idClient, int idAccount, int idTransaction)
			throws NotFoundException {
		Transaction transaction = this.transactionService.getTransaction(idClient, idAccount, idTransaction);
		
		return TransactionResponseView.from(transaction);
	}

}
