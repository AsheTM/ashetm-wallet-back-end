package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.entities.Account;

public interface AccountProcess {
	
	Account activateAccount(Account account);
	
	Account deactivateAccount(Account account);

}
