package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.exceptions.CardBalanceNotSufficientException;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public interface WalletProcess {

	Card makeTransaction(int idClient, int idCard, Transaction transaction)
			throws CardNotFoundException, TransactionNotFoundException, CardBalanceNotSufficientException;
	default Card withdraw(int idClient, int idCard, Transaction transaction) { return null; }
	default Card deposit(int idClient, int idCard, Transaction transaction) { return null; }

}
