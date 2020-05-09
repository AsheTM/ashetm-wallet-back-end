package dev.ashetm.wallet.exceptions;

public class ClientNotFoundException extends NotFoundException {
	
	public ClientNotFoundException() {
		super(CLIENT_NOT_FOUND);
	}

}
