package dev.ashetm.wallet.counter.controllers;

import java.util.List;

import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;
import dev.ashetm.wallet.counter.services.TransactionService;
import dev.ashetm.wallet.counter.views.responses.TransactionResponseView;
import dev.ashetm.wallet.counter.views.responses.TransactionsResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
