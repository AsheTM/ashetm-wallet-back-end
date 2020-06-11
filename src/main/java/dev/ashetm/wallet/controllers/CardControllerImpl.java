package dev.ashetm.wallet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.processes.CardProcess;
import dev.ashetm.wallet.processes.WalletProcess;
import dev.ashetm.wallet.services.CardService;
import dev.ashetm.wallet.views.CardResponseView;
import dev.ashetm.wallet.views.CardsResponseView;

@RestController
@CrossOrigin(
		origins = { "http://localhost:4200", "http://localhost:4201" }, 
		maxAge = 3_600, 
		allowedHeaders = { "*" })
public class CardControllerImpl implements WalletController.CardController {
	
	private CardService cardService;
	private CardProcess cardProcess;
	private WalletProcess walletProcess;
	
	@Autowired
	public CardControllerImpl(CardService cardService, 
			CardProcess cardProcess, 
			WalletProcess walletProcess) {
		this.cardService = cardService;
		this.cardProcess = cardProcess;
		this.walletProcess = walletProcess;
	}

	@Override
	public CardsResponseView showCards(int idClient) throws NotFoundException {
		List<Card> cards = this.cardService.getAllCards(idClient);
		
		return CardsResponseView.from(cards);
	}

	@Override
	public CardResponseView showCard(int idClient, int idCard) throws NotFoundException {
		Card card = this.cardService.getCard(idClient, idCard);
		
		return CardResponseView.from(card);
	}

	@Override
	public CardResponseView withdraw(int idClient, int idCard, Transaction transaction) 
			throws NotFoundException {
		Card card = this.cardService.getCard(idClient, idCard);
		card = this.walletProcess.withdraw(card, transaction);
		
		return CardResponseView.from(card);
	}

	@Override
	public CardResponseView deposit(int idClient, int idCard, Transaction transaction) 
			throws NotFoundException {
		Card card = this.cardService.getCard(idClient, idCard);
		card = this.walletProcess.deposit(card, transaction);
		
		return CardResponseView.from(card);
	}

	@Override
	public CardResponseView addCard(int idClient, Card card) throws NotFoundException {
		card = this.cardService.saveCard(idClient, card);
		
		return CardResponseView.from(card);
	}

	@Override
	public Boolean activateCard(int idClient, int idCard) throws NotFoundException {
		Card account = this.cardService.getCard(idClient, idCard);
		Boolean result = null;
		if(account != null) {
			account = this.cardProcess.activateAccount(account);
			result = Boolean.valueOf(account.isActivate());
		}
		
		return result;
	}

	@Override
	public Boolean deactivateCard(int idClient, int idCard) throws NotFoundException {
		Card card = this.cardService.getCard(idClient, idCard);
		Boolean result = null;
		if(card != null) {
			card = this.cardProcess.deactivateAccount(card);
			result = Boolean.valueOf(card.isActivate());
		}
		
		return result;
	}

}
