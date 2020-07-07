package dev.ashetm.wallet.counter.exceptions;

public class ClientNotFoundException extends NotFoundException {
	
	public ClientNotFoundException() {
		super(NotFoundException.CLIENT_NOT_FOUND);
	}

}
