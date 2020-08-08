package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.exceptions.BalanceCardNotSufficientException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public interface TransactionProcess {

	Card makeTransaction(int idClient, int idCard, Transaction transaction)
			throws NotFoundException, BalanceCardNotSufficientException;
	default Card withdraw(int idClient, int idCard, Transaction transaction) { return null; }
	default Card deposit(int idClient, int idCard, Transaction transaction) { return null; }

}
