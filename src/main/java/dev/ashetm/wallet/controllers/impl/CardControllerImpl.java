package dev.ashetm.wallet.controllers.impl;

import java.util.List;

import dev.ashetm.wallet.controllers.WalletController;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.PasswordCardInvalidFormatException;
import dev.ashetm.wallet.processes.CardProcess;
import dev.ashetm.wallet.views.request.CardRequestView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<CardResponseView> showCard(int idClient, int idCard) {
		Card card = null;
		HttpStatus httpStatus = HttpStatus.OK;

		try{
			card = this.cardService.getCard(idClient, idCard);
		} catch (CardNotFoundException cardNotFoundException) {
			LOGGER.error(cardNotFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		}

		return ResponseEntity
				.status(httpStatus)
				.body(CardResponseView.from(card));
	}

	@Override
	public ResponseEntity<CardsResponseView> showCards(int idClient) {
		List<Card> cards = this.cardService.getAllCards(idClient);
		
		return ResponseEntity.ok(CardsResponseView.from(cards));
	}

	@Override
	public ResponseEntity<CardResponseView> addCard(int idClient, CardRequestView cardRequestView) {
		Card card = CardRequestView.to(cardRequestView);
		Card cardSaved = null;
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			cardSaved = this.cardProcess.saveCard(idClient, card);
		} catch(NotFoundException notFoundException) {
			LOGGER.error(notFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		} catch(PasswordCardInvalidFormatException passwordCardInvalidFormatException) {
			LOGGER.error(passwordCardInvalidFormatException.getMessage());
			httpStatus = HttpStatus.NOT_ACCEPTABLE;
		}

		return ResponseEntity
				.status(httpStatus)
				.body(CardResponseView.from(cardSaved));
	}

	@Override
	public ResponseEntity<AuthenticateCardResponseView> authenticate(int idClient, int idCard,
													 AuthenticateCardRequestView authenticateCardRequestView) {
		Boolean authenticate = false;
		HttpStatus httpStatus = HttpStatus.OK;
		String password = authenticateCardRequestView.getPassword();

		try {
			authenticate = this.cardProcess.authenticate(idClient, idCard, password);
		} catch(NotFoundException notFoundException) {
			LOGGER.error(notFoundException.getMessage());
			httpStatus = HttpStatus.NO_CONTENT;
		}

		return ResponseEntity
				.status(httpStatus)
				.body(AuthenticateCardResponseView.from(authenticate));
	}

}
