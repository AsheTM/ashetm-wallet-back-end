package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import dev.ashetm.wallet.views.request.TransactionRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.processes.WalletProcess;
import dev.ashetm.wallet.services.CardService;
import dev.ashetm.wallet.views.request.AuthenticateCardRequestView;
import dev.ashetm.wallet.views.response.AuthenticateCardResponseView;
import dev.ashetm.wallet.views.response.CardResponseView;
import dev.ashetm.wallet.views.response.CardsResponseView;

@RestController
@CrossOrigin(
		origins = { "http://localhost:4200", "http://localhost:4201" }, 
		maxAge = 3_600, 
		allowedHeaders = { "*" })
public class CardControllerImpl implements WalletController.CardController {
	
	private CardService cardService;
	private WalletProcess walletProcess;
	
	@Autowired
	public CardControllerImpl(CardService cardService,
			WalletProcess walletProcess) {
		this.cardService = cardService;
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
	public CardResponseView addCard(int idClient, Card card) throws NotFoundException {
		card = this.cardService.saveCard(idClient, card);

		return CardResponseView.from(card);
	}
	
	@Override
	public AuthenticateCardResponseView authenticate(int idClient, int idCard,
													 AuthenticateCardRequestView authenticateCardRequestView)
			throws NotFoundException {
		String password = authenticateCardRequestView.getPassword();
		boolean authenticate = this.cardService.authenticate(idClient, idCard, password);
		
		return AuthenticateCardResponseView.from(authenticate);
	}

	@Override
	public CardResponseView withdraw(int idClient, int idCard,
									 TransactionRequestView transactionRequestView) throws NotFoundException {
		Transaction transaction = TransactionRequestView.to(transactionRequestView);

		Card card = this.cardService.getCard(idClient, idCard);
		card = this.walletProcess.withdraw(card, transaction);
		
		return CardResponseView.from(card);
	}

	@Override
	public CardResponseView deposit(int idClient, int idCard, TransactionRequestView transactionRequestView)
			throws NotFoundException {
		Transaction transaction = TransactionRequestView.to(transactionRequestView);

		Card card = this.cardService.getCard(idClient, idCard);
		card = this.walletProcess.deposit(card, transaction);
		
		return CardResponseView.from(card);
	}

}
