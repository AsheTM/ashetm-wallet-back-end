package dev.ashetm.wallet.counter.processes;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.models.Transaction;

@Component
public interface WalletProcess {
	
	Card withdraw(Card card, Transaction transaction);
	Card deposit(Card card, Transaction transaction);

}
