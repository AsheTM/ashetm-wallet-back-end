package dev.ashetm.wallet.processes;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Transaction;

@Component
public interface WalletProcess {
	
	Account withdraw(Account account, Transaction transaction);
	
	Account deposit(Account account, Transaction transaction);

}
