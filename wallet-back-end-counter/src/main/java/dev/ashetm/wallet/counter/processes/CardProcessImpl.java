package dev.ashetm.wallet.counter.processes;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.counter.models.Card;

@Component
public class CardProcessImpl implements CardProcess {

	@Override
	public Card activateAccount(Card card) {
		card.setActivate(true);
		
		return card;
	}

	@Override
	public Card deactivateAccount(Card card) {
		card.setActivate(false);
		
		return card;
	}
	
	

}
