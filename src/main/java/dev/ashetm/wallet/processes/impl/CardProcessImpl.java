package dev.ashetm.wallet.processes.impl;

import dev.ashetm.wallet.processes.CardProcess;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;

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
