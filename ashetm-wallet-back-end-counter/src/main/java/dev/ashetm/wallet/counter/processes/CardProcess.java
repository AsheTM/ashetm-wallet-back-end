package dev.ashetm.wallet.counter.processes;

import dev.ashetm.wallet.counter.models.Card;

public interface CardProcess {
	
	Card activateAccount(Card card);
	Card deactivateAccount(Card card);

}
