package dev.ashetm.wallet.counter.exceptions;

public class NotFoundException extends Exception {
	
	protected static String CLIENT_NOT_FOUND = "Client not found";
	protected static String CARD_NOT_FOUND = "Card not found";
	protected static String TRANSACTION_NOT_FOUND = "Transaction not found";
	
	public NotFoundException(String message) {
		super(message);
	}

}
