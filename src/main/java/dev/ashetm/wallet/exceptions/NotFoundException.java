package dev.ashetm.wallet.exceptions;

public class NotFoundException extends Exception {
	
	protected static String CLIENT_NOT_FOUND = "Client not found";
	
	protected static String ACCOUNT_NOT_FOUND = "Account not found";
	
	protected static String TRANSACTION_NOT_FOUND = "Transaction not found";
	
	public NotFoundException(String message) {
		super(message);
	}

}
