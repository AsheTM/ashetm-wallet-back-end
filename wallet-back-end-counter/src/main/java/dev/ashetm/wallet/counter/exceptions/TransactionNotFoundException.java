package dev.ashetm.wallet.counter.exceptions;

public class TransactionNotFoundException extends NotFoundException {
	
	public TransactionNotFoundException() {
		super(NotFoundException.TRANSACTION_NOT_FOUND);
	}
	
}
