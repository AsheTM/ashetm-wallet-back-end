package dev.ashetm.wallet.processes.impl;

import java.math.BigDecimal;

import dev.ashetm.wallet.exceptions.BalanceCardNotSufficientException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;
import dev.ashetm.wallet.processes.TransactionProcess;
import dev.ashetm.wallet.services.CardService;
import dev.ashetm.wallet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public class TransactionProcessImpl implements TransactionProcess {

	@Autowired
	private CardService cardService;

	@Autowired
	private TransactionService transactionService;

	@Override
	public Card makeTransaction(int idClient, int idCard, Transaction transaction)
			throws NotFoundException, BalanceCardNotSufficientException {
		Card card = this.cardService.getCard(idClient, idCard);

		if(transaction.equals(null))
			throw new TransactionNotFoundException();

		BigDecimal amount = transaction.getAmount();
		BigDecimal balance = card.getBalance();

		BigDecimal result = balance.add(amount);

		if(result.doubleValue() < 0)
			throw new BalanceCardNotSufficientException(card);

		card.setBalance(result);
		transaction.setCard(card);
		transactionService.saveTransaction(transaction);

		return card;
	}

}
