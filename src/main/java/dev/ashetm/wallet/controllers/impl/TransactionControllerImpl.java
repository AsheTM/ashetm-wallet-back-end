package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.CardBalanceNotSufficientException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;
import dev.ashetm.wallet.processes.WalletProcess;
import dev.ashetm.wallet.views.request.TransactionRequestView;
import dev.ashetm.wallet.views.response.BalanceCardResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private WalletProcess walletProcess;

	private final Logger LOGGER = LoggerFactory.getLogger(TransactionControllerImpl.class);
	
	@Autowired
	public TransactionControllerImpl(TransactionService transactionService,
									 WalletProcess walletProcess) {
		this.transactionService = transactionService;
		this.walletProcess = walletProcess;
	}
	
	@Override
	public ResponseEntity<TransactionsResponseView> showTransactions(int idClient, int idCard) {
		List<Transaction> transactions = this.transactionService.getAllTransaction(idClient, idCard);

		return ResponseEntity.ok(TransactionsResponseView.from(transactions));
	}
	
	@Override
	public ResponseEntity<TransactionResponseView> showTransaction(int idClient, int idCard, int idTransaction) {
		HttpStatus httpStatus = HttpStatus.OK;
		Transaction transaction = null;

		try {
			transaction = this.transactionService.getTransaction(idClient, idCard, idTransaction);
		} catch(TransactionNotFoundException transactionNotFoundException) {
			LOGGER.error(transactionNotFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		}
		
		return ResponseEntity
				.status(httpStatus)
				.body(TransactionResponseView.from(transaction));
	}

	@Override
	public ResponseEntity<BalanceCardResponseView> makeTransaction(int idClient, int idCard,
												   TransactionRequestView transactionRequestView) {
		Card card = null;
		HttpStatus httpStatus = HttpStatus.OK;
		Transaction transaction = TransactionRequestView.to(transactionRequestView);

		try {
			card = this.walletProcess.makeTransaction(idClient, idCard, transaction);
		} catch(CardBalanceNotSufficientException cardBalanceNotSufficientException) {
			LOGGER.error(cardBalanceNotSufficientException.getMessage());
			httpStatus = HttpStatus.PRECONDITION_REQUIRED;
		} catch(NotFoundException notFoundException) {
			LOGGER.error(notFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		}

		return ResponseEntity
				.status(httpStatus)
				.body(BalanceCardResponseView.from(card));
	}

}
