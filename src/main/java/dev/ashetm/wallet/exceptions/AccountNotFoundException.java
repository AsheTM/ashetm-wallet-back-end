package dev.ashetm.wallet.exceptions;

public class AccountNotFoundException extends NotFoundException {
	
	public AccountNotFoundException() {
		super(ACCOUNT_NOT_FOUND);
	}

}
