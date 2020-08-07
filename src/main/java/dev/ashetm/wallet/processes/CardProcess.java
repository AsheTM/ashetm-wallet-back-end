package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.entities.Card;

public interface CardProcess {
	
	Card activateAccount(Card card);
	Card deactivateAccount(Card card);

}
