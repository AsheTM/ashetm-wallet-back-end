package dev.ashetm.wallet.processes;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Account;

@Component
public class AccountProcessImpl implements AccountProcess {

	@Override
	public Account activateAccount(Account account) {
		account.setActivate(true);
		
		return account;
	}

	@Override
	public Account deactivateAccount(Account account) {
		account.setActivate(false);
		
		return account;
	}
	
	

}
