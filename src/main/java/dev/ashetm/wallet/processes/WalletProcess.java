package dev.ashetm.wallet.processes;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public interface WalletProcess {
	
	Card withdraw(Card card, Transaction transaction);
	Card deposit(Card card, Transaction transaction);

}
