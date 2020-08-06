package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.services.TransactionService;
import dev.ashetm.wallet.views.response.TransactionResponseView;
import dev.ashetm.wallet.views.response.TransactionsResponseView;

@RestController
@CrossOrigin(
		origins = { "http://localhost:4200", "http://localhost:4201" }, 
		maxAge = 3_600, 
		allowedHeaders = { "*" })
public class TransactionControllerImpl implements WalletController.TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@Override
	public TransactionsResponseView showTransactions(int idClient, int idCard) throws NotFoundException {
		List<Transaction> transactions = this.transactionService.getAllTransaction(idClient, idCard);
		
		return TransactionsResponseView.from(transactions);
	}
	
	@Override
	public TransactionResponseView showTransaction(int idClient, int idCard, int idTransaction)
			throws NotFoundException {
		Transaction transaction = this.transactionService.getTransaction(idClient, idCard, idTransaction);
		
		return TransactionResponseView.from(transaction);
	}

}
