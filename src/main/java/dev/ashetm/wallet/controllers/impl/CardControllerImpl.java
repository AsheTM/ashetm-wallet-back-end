package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.processes.CardProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.NotFoundException;
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

	private CardProcess cardProcess;
	private CardService cardService;

	private final Logger LOGGER = LoggerFactory.getLogger(CardControllerImpl.class);
	
	@Autowired
	public CardControllerImpl(CardProcess cardProcess,
							  CardService cardService) {
		this.cardProcess = cardProcess;
		this.cardService = cardService;
	}

	@Override
	public CardResponseView showCard(int idClient, int idCard) {
		Card card = null;

		try{
			card = this.cardService.getCard(idClient, idCard);
		} catch (CardNotFoundException cardNotFoundException) {
			LOGGER.error(cardNotFoundException.getMessage());
		}

		return CardResponseView.from(card);
	}

	@Override
	public CardsResponseView showCards(int idClient) {
		List<Card> cards = this.cardService.getAllCards(idClient);
		
		return CardsResponseView.from(cards);
	}

	@Override
	public CardResponseView addCard(int idClient, Card card) {
		card = this.cardService.saveCard(idClient, card);

		return CardResponseView.from(card);
	}

	@Override
	public AuthenticateCardResponseView authenticate(int idClient, int idCard,
													 AuthenticateCardRequestView authenticateCardRequestView) {
		String password = authenticateCardRequestView.getPassword();
		Boolean authenticate = false;

		try {
			authenticate = this.cardProcess.authenticate(idClient, idCard, password);
		} catch(NotFoundException notFoundException) {
			LOGGER.error(notFoundException.getMessage());
		}

		return AuthenticateCardResponseView.from(authenticate);
	}

}
