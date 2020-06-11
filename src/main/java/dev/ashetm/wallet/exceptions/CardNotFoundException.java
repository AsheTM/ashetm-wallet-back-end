package dev.ashetm.wallet.exceptions;

public class CardNotFoundException extends NotFoundException {
	
	public CardNotFoundException() {
		super(CARD_NOT_FOUND);
	}

}
