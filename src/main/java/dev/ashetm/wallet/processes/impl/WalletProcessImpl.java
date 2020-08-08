package dev.ashetm.wallet.processes.impl;

import java.math.BigDecimal;

import dev.ashetm.wallet.exceptions.CardBalanceNotSufficientException;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;
import dev.ashetm.wallet.processes.WalletProcess;
import dev.ashetm.wallet.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public class WalletProcessImpl implements WalletProcess {

	@Autowired
	private CardService cardService;

	@Override
	public Card makeTransaction(int idClient, int idCard, Transaction transaction)
			throws CardNotFoundException, TransactionNotFoundException, CardBalanceNotSufficientException {
		Card card = this.cardService.getCard(idClient, idCard);

		if(transaction.equals(null))
			throw new TransactionNotFoundException();

		BigDecimal amount = transaction.getAmount();
		BigDecimal balance = card.getBalance();

		BigDecimal result = balance.add(amount);

		if(result.doubleValue() < 0)
			throw new CardBalanceNotSufficientException(card);

		card.setBalance(result);

		return card;
	}

}
